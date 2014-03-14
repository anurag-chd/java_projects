import visidia.simulation.process.algorithm.Algorithm;
import visidia.simulation.process.algorithm.SynchronousAlgorithm;
import visidia.simulation.process.edgestate.MarkedState;
import visidia.simulation.process.messages.IntegerMessage;
import visidia.simulation.process.messages.StringMessage;

public class Publickey extends SynchronousAlgorithm {
	
	@Override
	public Object clone() {
	return new Publickey();
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
	      nextPulse();
	      }
	      
	      if(getId()==2 && getPulse() ==1){
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
	      putProperty("label",new String("Alice"));
	      sendTo(door_as, new StringMessage("A->S:A,B"));   
	      nextPulse();
	      }
	      else{
	      //else if(anyMsgDoor(1)){
	      door_as=1;
	      door_ab=0;     
	      putProperty("label",new String("Alice"));
	      sendTo(door_as, new StringMessage("A->S:A,B"));   
	      nextPulse();
	      
	      }
	      }
	      
	      if(getId()==2 && getPulse() ==2){
	      putProperty("label",new String("Bob"));
	      //sendTo(0, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }
	      
	      
	      /////////////////////////////////////////////////////////////////////
	      
	      ///////////////////////third pulse/////////////////////////
	      if(getId()==0 && getPulse() == 3){
	      sendTo(door_sa, new StringMessage("S->A:{Kpb,B}kss")); 
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
	      sendTo(door_sb, new StringMessage(" "));
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 4){
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
	      door_bs=1;
	      door_ba=0;
	      sendTo(door_bs, new StringMessage("B->S:B,A"));   
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
	      sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 6){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 6){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      ///////////////////////////
	      ///////////////////////////seventh pulse////////////////////
	      if(getId()==0 && getPulse() == 7){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 7){
	      sendTo(door_ab, new StringMessage("A->B:{Na,A}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 7){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      ////////////////////
	      ////////////////////eight pulse////////////////////
	      if(getId()==0 && getPulse() == 8){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 8){
	      //sendTo(door_ab, new StringMessage("A->B:{Na,A}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 8){
	      sendTo(door_ba, new StringMessage("B->A:{Na,Nb}kpa")); 
	      setDoorState(new MarkedState(true),door_ba);
	      nextPulse();
	      }
	      ///////////////////
	      ////////////////////ninth pulse//////////////////
	      if(getId()==0 && getPulse() == 9){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 9){
	      putProperty("label",new String("Alice{Communication Established}"));
	      sendTo(door_ab, new StringMessage("A->B:{Nb}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 9){
	      putProperty("label",new String("Bob{Communication Established}"));
	      //sendTo(door_ba, new StringMessage("B->A:{Na,Nb}kpa")); 
	      //setDoorState(new MarkedState(true),i);
	      nextPulse();
	      }
	}
}	     