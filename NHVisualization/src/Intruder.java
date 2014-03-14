import visidia.simulation.process.algorithm.Algorithm;
import visidia.simulation.process.algorithm.SynchronousAlgorithm;
import visidia.simulation.process.edgestate.MarkedState;
import visidia.simulation.process.messages.IntegerMessage;
import visidia.simulation.process.messages.StringMessage;

public class Intruder extends SynchronousAlgorithm {
	
	@Override
	public Object clone() {
	return new Intruder();
	}
	@Override
	public void init() {
	//java.util.Random r = new java.util.Random();
	int nbNeighbors = getArity();
	int door_sa,door_sb,door_as,door_ab,door_bs,door_ba;
	   int door_ai=0;
	   int door_ia=0;
	   int door_ib=0;
	   int door_bi=0;
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
	      if(getId()==3 && getPulse() ==1){
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
	      door_ai=1;
	      putProperty("label",new String("Alice"));
	      sendTo(door_as, new StringMessage("A->S:A,B"));   
	      nextPulse();
	      }
	      else{
	      //else if(anyMsgDoor(1)){
	      door_as=1;
	      door_ai=0;     
	      putProperty("label",new String("Alice"));
	      sendTo(door_as, new StringMessage("A->S:A,B"));   
	      nextPulse();
	      
	      }
	      }
	      
	      if(getId()==2 && getPulse() ==2){
	      putProperty("label",new String("Bob"));
	      //sendTo(door_bs, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }
	      
	      if(getId()==3 && getPulse() ==2){
	    	   	  
	      putProperty("label",new String("Intruder"));
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
	      
	      if(getId()==3 && getPulse() == 3){
	    	 
	    	  nextPulse();
	      }
	      
	      ////////////////////////////////////////////////
	      ///////fourth pulse/////////////////////////////
	      if(getId()==0 && getPulse() == 4){
	      sendTo(door_sb, new StringMessage("  "));
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 4){
	    	  putProperty("label",new String("A: authenticated"));
	    	  nextPulse();
	      }
	      if(getId()==2 && getPulse() == 4){
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 4){
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
	      /*if(anyMsgDoor(0)){
	      door_bs=0;
	      door_bi=1;
	      sendTo(door_bs, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }
	      else{*/
	      //else if(anyMsgDoor(1)){
	      door_bs=0;
	      door_bi=1;
	      //putProperty("label",new String("Bob"));
	      sendTo(door_bs, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      //}
	      }
	      if(getId()==3 && getPulse() == 5){
	      nextPulse();
	      }
	      
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
	      if(getId()==3 && getPulse() == 6){
	      nextPulse();
	      }
	      ///////////////////////////
	      ///////////////////////////seventh pulse////////////////////
	      if(getId()==0 && getPulse() == 7){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 7){
	      sendTo(door_ai, new StringMessage("A->B:{Na,A}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 7){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	    	  putProperty("label",new String("B: authenticated"));
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 7){
	      putProperty("label",new String("Middle Man Attack Started"));	  
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
	      //sendTo(door_ba, new StringMessage("B->A:{Na,Nb}kpa")); 
	      //setDoorState(new MarkedState(true),door_ba);
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 8){
	      //if(anyMsgDoor(0)){
	      
	      door_ia=0;
	      door_ib=1;
	    	  
	    	  
	    	  
	      sendTo(door_ib, new StringMessage("I->B:{Na,A}Kpb"));
	    	  
	      //sendTo(1, new StringMessage("Anurag"));
	      nextPulse();
	      /*}
	      else{
	      //else if(anyMsgDoor(1)){
	      door_ia=1;
	      door_ib=0;
	      //putProperty("label",new String("Bob"));
	      sendTo(door_ib, new StringMessage("B->S:B,A"));   
	      nextPulse();
	      }*/
	      //sendTo(door_ba, new StringMessage("B->A:{Na,Nb}kpa"));
	      
	      }
	      
	      ///////////////////
	      ////////////////////ninth pulse//////////////////
	      if(getId()==0 && getPulse() == 9){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 9){
	      //putProperty("label",new String("Alice{Communication Established}"));
	      //sendTo(door_ab, new StringMessage("A->B:{Nb}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 9){
	      //putProperty("label",new String("Bob{Communication Established}"));
	      putProperty("label",new String("B->Communication established with A")); 
	      sendTo(door_bi, new StringMessage("B->I:{Na,Nb}kpa")); 
	      setDoorState(new MarkedState(true),door_bi);
	      //setDoorState(new MarkedState(true),i);
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 9){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      
	      //////////////////
	      //////////////////tenth pulse//////////////////////////
	      if(getId()==0 && getPulse() == 10){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 10){
	      //putProperty("label",new String("Alice{Communication Established}"));
	      //sendTo(door_ab, new StringMessage("A->B:{Nb}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 10){
	      //putProperty("label",new String("Bob{Communication Established}"));
	      //sendTo(door_bi, new StringMessage("B->A:{Na,Nb}kpa")); 
	      //setDoorState(new MarkedState(true),i);
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 10){
	      sendTo(door_ia, new StringMessage("I->A:{Na,Nb}kpa")); 
	      nextPulse();
	      }
	      ////////////////////
	      //////////////////// eleventh pulse////////////////
	      if(getId()==0 && getPulse() == 11){
	      
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 11){
	      //putProperty("label",new String("Alice{Communication Established}"));
	      sendTo(door_ai, new StringMessage("A->I:{Nb}kpi")); 
	      putProperty("label",new String("A-> Response from B"));
	      setDoorState(new MarkedState(true),door_ai);
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 11){
	      //putProperty("label",new String("Bob{Communication Established}"));
	      //sendTo(door_bi, new StringMessage("B->A:{Na,Nb}kpa")); 
	      //setDoorState(new MarkedState(true),i);
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 11){
	      //sendTo(door_ia, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      /////////////
	      ////////////// twelfth pulse
	       if(getId()==0 && getPulse() == 12){
	      //sendTo(door_sb, new StringMessage("S->B:{Kpa,A}kss")); 
	      nextPulse();
	      }
	      if(getId()==1 && getPulse() == 12){
	      //putProperty("label",new String("Alice{Communication Established}"));
	      //sendTo(door_ai, new StringMessage("A->B:{Nb}kpb")); 
	      nextPulse();
	      }
	      if(getId()==2 && getPulse() == 12){
	      //putProperty("label",new String("Bob{Communication Established}"));
	      //sendTo(door_bi, new StringMessage("B->A:{Na,Nb}kpa")); 
	      //setDoorState(new MarkedState(true),i);
	      nextPulse();
	      }
	      if(getId()==3 && getPulse() == 12){
	      sendTo(door_ib, new StringMessage("I->B:{Nb}kpb")); 
	      nextPulse();
	      }
	      ////////////////////////////////////////////
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      }
	      }
	      
	      