package sources.visidia.simulation.synchro.synAlgos;

import sources.visidia.misc.IntegerMessage;
import sources.visidia.misc.MSG_TYPES;
import sources.visidia.misc.Message;
import sources.visidia.misc.SyncState;
import sources.visidia.misc.SynchronizedRandom;
import sources.visidia.simulation.synchro.SynCT;

public class RDV extends AbSynAlgo implements IntSynchronization {
    public RDV() {
	super();
    }

    public Object clone() {
	return new RDV();
    }
    public String toString(){
	return "RDV";
    }
    
    /* a duel , useful for RDV family algorithms */
    public boolean duelWith(int neighbour){
	int my = 0;
	int his = 0;
	while (synob.isConnected(neighbour) && my == his) {
	    my = Math.abs(SynchronizedRandom.nextInt());
	    boolean b = sendTo(neighbour, new IntegerMessage(my, MSG_TYPES.DUEL));
	    synob.setConnected(neighbour, b);
	    if (synob.isConnected(neighbour)) {
		IntegerMessage msg = (IntegerMessage) receiveFrom(neighbour);
		if (msg != null) {
		    his = msg.value();
		    if (my != his) {
			return my > his;
		    }
		} else {
		    synob.setConnected(neighbour, false);
		    return false;
		}
	    }
	}
        return false;
    }
    	
    public void trySynchronize() {
	/* Synchronisation Algorithme */
	int arity = getArity();
        answer = new int[arity];
	
	//waitWhileDisconnected();
	
	synob.reset();//setNeighbourhood(s);//reset
	
	/*choice of the neighbour*/
	int door = getRandomConnectedDoor();
	
	boolean b = sendTo(door, new IntegerMessage(1, MSG_TYPES.SYNC));
	synob.setConnected(door, b);
        for (int i = 0; i < arity; i++){
            if (i != door) {
                b = sendTo(i, new IntegerMessage(0,MSG_TYPES.SYNC));
		synob.setConnected(i, b);
	    }
	}
        
        for (int i = 0; i < arity; i++) {
	    if (synob.isConnected(i)) {
		IntegerMessage msg = (IntegerMessage) receiveFrom(i);
		if (msg != null) {
		    answer[i]= msg.value();
		    if(msg.getType().equals(MSG_TYPES.TERM)){
			if (answer[i]== SynCT.LOCAL_END)
			    synob.setFinished(i,true);
			if(answer[i] == SynCT.GLOBAL_END){
			    synob.setGlobEnd(true);
			    synob.setFinished(i,true);
			}
		    }
		} else {
		    synob.setConnected(i, false);
		}
	    }
	}
	
	//PFA2003 derniere chance
	for (int i = 0; i < arity; i++) {
	    if (! synob.isConnected(i)) {
		b = sendTo(i, new IntegerMessage(0,MSG_TYPES.SYNC));
		synob.setConnected(i, b);
		if (b) {
		    IntegerMessage msg = (IntegerMessage) receiveFrom(i);
		    if (msg != null) {
			answer[i]= msg.value();
		    } else {
			synob.setConnected(i, false);
		    }
		}
	    }
	}

	if (synob.isConnected(door) && answer[door] == 1){
	    if(duelWith(door)) {
		setDoorState(new SyncState(true),door);
		synob.addSynchronizedDoor(door);
		synob.setState(SynCT.IAM_THE_CENTER);    
		return;
	    } else {
		synob.center = door;
		synob.setState(SynCT.IN_THE_STAR);
		return;
	    }
	} else
	    synob.setState(SynCT.NOT_IN_THE_STAR);
	//System.out.println ("----" + getId() + " 6");
	return;
    }
    
    public void reconnectionEvent(int door) {
	Message m;
	while ((m = receiveFrom(door)) != null) {
	}
    }
} 
      
