package sources.visidia.algo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;

import sources.visidia.misc.MarkedState;
import sources.visidia.misc.Message;
import sources.visidia.misc.MessageType;
import sources.visidia.misc.StringMessage;
import sources.visidia.simulation.Algorithm;
import sources.visidia.simulation.Door;

public class BroadcastRandomSpeedWithTermination extends Algorithm {
    
    
    static MessageType termination = new MessageType("termination", true, new java.awt.Color(16,154,241));
    static MessageType wave = new MessageType("Wave", true);
    static MessageType ack = new MessageType("Acknowledgment", true, java.awt.Color.blue);
    
    public Collection getListTypes(){
        Collection typesList = new LinkedList();
        typesList.add(ack);
        typesList.add(wave);
        typesList.add(termination);
        return typesList;
    }
    
    public void init(){
	int degres = getArity() ;
	int fatherDoor;
	int[] childrenStates = new int[degres];
	Random generator = new Random();
	boolean terminated = false;
	String label = (String) getProperty("label");
	
	// sommet root
	if(label.compareTo("A") == 0) {
	    // debut de la vague
	    for(int i=0; i < degres; i++){
		sendTo(i, new StringMessage("Wave",wave));
		try{
		    int timeToSleep = (generator.nextInt() % 20 )* 1000;
		    Thread.sleep(timeToSleep);
		} catch (Exception e) {}
	    }
	    
	    // attente des reponses des voisins et detection de la terminaison
	    while(!terminated){
		Door door = new Door();
		StringMessage msg = (StringMessage)receive(door);
		int doorNum= door.getNum();
		String data = msg.data();
		if(data.compareTo("Ack_Yes")==0) {
		    // j'attends encore l'aqcuitement de terminason
		    childrenStates[doorNum]=-1;
		} else if(data.compareTo("Ack_No")==0) {
		    // j'attends plus rien de ce voisin
		    childrenStates[doorNum]=1;
		} else if(data.compareTo("Wave")==0) {
		    sendTo(doorNum, new StringMessage("Ack_No",ack));
		} else if(data.compareTo("END")==0) {
		    // terminaison sur le sous arbre correspondant
		    // j'attends plus rien
		    childrenStates[doorNum]=1;
		}
		
		terminated = true;
		for( int i = 0; i < degres; i++ ) {
		    if(childrenStates[i]!=1)
			// j'attends encore un Ack ou un END
			terminated = false;
		}
	    }
	    // terminaison detecte
	    putProperty("label",new String("L"));
	
	} else {
	    // je suis bloque en attente de la vague
	    Door doorB = new Door();
	    Message msgB = receive(doorB);
	    
	    //je recois un message; la vague est arrivee
	    fatherDoor = doorB.getNum();

	    // je renvoi un accusee de reception a celui qui m a informe : mon pere
      	    sendTo(fatherDoor,new StringMessage("Ack_Yes",ack));

	    // je me ratache a mon pere dans l'arbre
	    putProperty("label",new String("I"));
	    setDoorState(new MarkedState(true),fatherDoor);

	    // je propage la vague
	    for(int i=0; i < degres; i++){
		if(i != fatherDoor) {
		    try{
			int timeToSleep = (generator.nextInt() % 20 )* 1000;
			Thread.sleep(timeToSleep);
		    } catch (Exception e) {}		    
		 
		    sendTo(i, new StringMessage("Wave",wave));
		}
	    }
	    
	    // detection de la terminaison
	    childrenStates[fatherDoor]=1;
	    // si j'ai des voisins a part mon pere
	    if (degres != 1) {
		while(!terminated){
		    Door door = new Door();
		    StringMessage msg = (StringMessage)receive(door);
		    int doorNum= door.getNum();
		    String data = msg.data();
		    if(data.compareTo("Ack_Yes")==0) {
			childrenStates[doorNum]=-1;
		    } else if(data.compareTo("Ack_No")==0) {
			childrenStates[doorNum]=1;
		    } else if(data.compareTo("Wave")==0) {
			sendTo(doorNum, new StringMessage("Ack_No",ack));
		    } else if(data.compareTo("END")==0) {
			childrenStates[doorNum]=1;
		    }
		    
		    terminated = true;
		    for( int i = 0; i < degres; i++ ) {
			if(childrenStates[i]!=1)
			    terminated = false;
		    }
		}
	    }
	    
	    // terminaison dans le sous arbre detecte : j'envoi ack a mon pere 
	    sendTo(fatherDoor, new StringMessage("END",termination));
	    // j'ai localement termine
	    putProperty("label",new String("F"));
	}
    }

    public Object clone(){
        return new  BroadcastRandomSpeedWithTermination();
    }

}

