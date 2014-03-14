import visidia.simulation.process.algorithm.Algorithm;
import visidia.simulation.process.algorithm.SynchronousAlgorithm;
import visidia.simulation.process.edgestate.MarkedState;
import visidia.simulation.process.messages.IntegerMessage;
import visidia.simulation.process.messages.StringMessage;

public class Symmetric extends SynchronousAlgorithm {
	
	@Override
	public Object clone() {
	return new Symmetric();
	}
	@Override
	public void init() {
	//java.util.Random r = new java.util.Random();
	int nbNeighbors = getArity();
	int door_sa,door_sb,door_as,door_ab,door_bs,door_ba;
	   door_ab=0;
	   door_ba=0;
	   door_sa=0;
	   door_sb=1;
	   
		//////first pulse//////////////////////////////////	
	      if (getId()==0  ){
			sendTo(door_sa, new StringMessage("  "));
	      //sendTo(door_sb, new StringMessage("  "));
			putProperty("label",new String("Server")); 
	      nextPulse();
	      }
	      
	      if(getId()==1 && getPulse() ==1){
	      putProperty("label",new String("Alice"));  
	      nextPulse();
	      }
	      
	      if(getId()==2 && getPulse() ==1){
	      putProperty("label",new String("Bob"));
	      nextPulse();
	      }
	      ////////////////////////////////////////////////////
	      
	      
	      ///////////////second pulse///////////////////////
	      if(getId()==0 && getPulse() ==2){
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() ==2){
	      if(receiveFrom(0)!=null){
	      door_as=0;
	      door_ab=1;
	      
	      sendTo(door_as, new StringMessage("A->S:A,B,Na"));   
	      nextPulse();
	      }
	      else{
	      //else if(anyMsgDoor(1)){
	      door_as=1;
	      door_ab=0;     
	      //putProperty("label",new String("Alice"));
	      sendTo(door_as, new StringMessage("A->S:A,B,Na"));   
	      nextPulse();
	      
	      }
	      }
	      
	      if(getId()==2 && getPulse() ==2){
	      
	      //sendTo(0, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }
	      
	      
	      /////////////////////////////////////////////////////////////////////
	      
	      ///////////////////////third pulse/////////////////////////
	      if(getId()==0 && getPulse() == 3){
	      sendTo(door_sa, new StringMessage("S->A:{Na,Kab,B,{Kab,A}kab}kas")); 
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      
	      if(getId()==1 && getPulse() ==3){
	      nextPulse();
	      }
	      
	      
	      if(getId()==2 && getPulse() == 3){
	    	  
	      nextPulse();
	      }
	      
	      
	      ////////////////////////////////////////////////
	      ///////fourth pulse/////////////////////////////
	      if(getId()==0 && getPulse() == 4){
	      //sendTo(door_sb, new StringMessage(" "));
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 4){
	    	  putProperty("label",new String("Authenticated"));
	    	  sendTo(door_ab, new StringMessage("A->B:{Kab,A}kbs"));
	    	  nextPulse();
	      }
	      if(getId()==2 && getPulse() == 4){
	      nextPulse();
	      }
	      
	      ///////////////////
	      ///////////////////fifth pulse////////////
	      if(getId()==0 && getPulse() == 5){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 5){
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 5){
	      //if(receiveFrom(0)!=null){
	      //door_bs=1;
	      door_ba=0;
	      sendTo(door_ba, new StringMessage("B->A:{Nb}kab"));   
	      putProperty("label",new String("Communication Procedure Starts"));
	      setDoorState(new MarkedState(true),door_ba);
	      nextPulse();
	      }
	      /*else{
	      //else if(anyMsgDoor(1)){
	      door_bs=1;
	      door_ba=0;
	      //putProperty("label",new String("Bob"));
	      sendTo(door_bs, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }
		}*/
	      
	      ///////////////////////////sixth pulse/////////
	      if(getId()==0 && getPulse() == 6){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 6){
	      sendTo(door_ab, new StringMessage("A->B:{Nb-1}kab"));
	      putProperty("label",new String("Communication Established"));
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 6){
	      putProperty("label",new String("Communication Established"));	  
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      ///////////////////////////
	      ///////////////////////////seventh pulse////////////////////
	      
	}
}	     