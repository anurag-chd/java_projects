import visidia.*;
import visidia.simulation.*;
import visidia.simulation.process.algorithm.Algorithm;
import visidia.simulation.process.messages.StringMessage;
import visidia.misc.*;
import visidia.simulation.process.algorithm.Algorithm;
import visidia.simulation.process.edgestate.MarkedState;
import visidia.simulation.process.messages.IntegerMessage;
import visidia.simulation.process.messages.StringMessage;
import java.util.*;



public class MyNewAlgo extends Algorithm {
	
	@Override
	public Object clone() {
	return new MyNewAlgo();
	}
	@Override
	public void init() {
   String label = (String)getProperty("label");
	//String label1 = (String)getProperty("label1");
   //boolean rendezVousAccepted = false;
	int nbNeighbors = getArity();
	
   
   
		
      
      while(true){
    	 // if (getId()==0  ){
    			sendTo(0, new StringMessage("Anurag "));
    	      sendTo(1, new StringMessage("Anurag "));
    			putProperty("label",new String("Server")); 
    	      //}
      // Receive a message
		/*
		for (int i = 0; i < nbNeighbors; ++i) {
      //for (int i = 0; i < nbNeighbors; ++i) {
		StringMessage msg = (StringMessage) receiveFrom(i);
      if(getId() == 1){
      if(msg.getData().toString().equals(" ")){
      putProperty("label",new String("Alice"));
      sendTo(i, new StringMessage("A->S:A,B"));   
      }
      }
      if(getId() == 2){
      if(msg.getData().toString().equals(" ")){
      putProperty("label",new String("BoB"));
      sendTo(i, new StringMessage("B->S:B,A"));   
      }
      }
               
      if(msg.getData().toString().equals("A->S:A,B"))
      sendTo(i, new StringMessage("S->A:{Kpb,B}kss"));   
      if(msg.getData().toString().equals("B->S:B,A"))
      sendTo(i, new StringMessage("S->B:{Kpa,A}kss"));   
      }
*/         
      }
      //}
      
    }
		}
	//	}
   
