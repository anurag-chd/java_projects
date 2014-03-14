package sources.visidia.simulation.rulesDist;

import sources.visidia.misc.BooleanMessage;
import sources.visidia.misc.IntegerMessage;
import sources.visidia.misc.MSG_TYPES;
import sources.visidia.misc.MarkedState;
import sources.visidia.misc.Message;
import sources.visidia.misc.NeighbourMessage;
import sources.visidia.misc.StringMessage;
import sources.visidia.rule.Neighbour;
import sources.visidia.rule.RSOptions;
import sources.visidia.rule.RelabelingSystem;
import sources.visidia.rule.Rule;
import sources.visidia.rule.Star;
import sources.visidia.simulation.AlgorithmDist;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synObj.SynObjectRules;

public abstract class AbstractRuleDist extends AlgorithmDist {
   /** The relabeling System to simulate */
    protected RelabelingSystem relSys = new RelabelingSystem();
    /** The synchronization used for simulation */
    protected int synType;//type de synchronisation
    
    /**
     * constructeurs
     **/
    public AbstractRuleDist(){
	super();
	addMessageType(MSG_TYPES.SYNC);
	addMessageType(MSG_TYPES.LABE);
	addMessageType(MSG_TYPES.TERM);
    }
    public AbstractRuleDist(RelabelingSystem r){
	super();
	setRelSys(r);
	addMessageType(MSG_TYPES.SYNC);
	addMessageType(MSG_TYPES.LABE);
	addMessageType(MSG_TYPES.TERM);
    }
    public String toString(){
	return "Abstract RuleDist"+super.toString();
    }
    abstract public Object clone();
    
    public void copy(AbstractRuleDist a){
	//super.copy(a);
	setRelSys(a.getRelSys());	
    }
  
    //**************** COMMON PART WITH VISIDIA CENTRALISEE ***************/
   /**
    * used to print. (for tests).
    * @return 
    */ 
    public String print(){
	return (" RSAlgo: opt="+relSys.userPreferences.toString()+"\n RS="+relSys.toString());    
    } 
  /** this methode receive from all synchronized neighbours their states, and update the information in the synob. 
    * this methode works with all synchronization algorithms.
    */ 
    
    public void updateNeigborhoodInfo()
    {
	int door;
	int i;
	SynObjectRules synob = new SynObjectRules();
	/* i receive the update */
	((SynObjectRules) synob).setCenterState((String) getProperty("label"));

	for(i=0; i< ((SynObjectRules) synob).neighbourhood.arity();i++){
	    door = ((SynObjectRules) synob).neighbourhood.neighbourDoor(i);
	    if (synob.isConnected(door)) {
		Message m = receiveFrom(door);
		if (m != null) {
		    StringMessage msg = (StringMessage) m;
		    Neighbour n = new Neighbour((String)msg.data(), 
						synob.getMark(door), door);
		    ((SynObjectRules) synob).neighbourhood.setState(i, n);
		} else {
		    synob.setConnected(i, false);
		}
	    }
	}
    }
    /** send the states (described in synob) to synchronized neighbours.
    * this method is used by the center after a transformation.
    * Warning: this methode is available only for RDV or LC2 synchronization types.
    * it should be redefined for LC1.
    */
    public void sendUpdate(){
	Neighbour n ;
	SynObjectRules synob = new SynObjectRules();
	String c = ((SynObjectRules)synob).neighbourhood.centerState() ;
	int i;
	setMyState(c);
       	//System.out.println("in sendup neigh="+synob.neighbourhood);
	for(i = 0; i < ((SynObjectRules)synob).neighbourhood.arity(); i++) {
	    n = ((SynObjectRules)synob).neighbourhood.neighbour(i);
	    setDoorState(new MarkedState(n.mark()), n.doorNum());
	    synob.setMark(n.doorNum(),n.mark());
	    if (synob.isConnected(n.doorNum())) {
		switch (synType){
		case SynCT.LC1 :
		    sendTo(n.doorNum(), 
			   new BooleanMessage((boolean) n.mark(), MSG_TYPES.MARK));
		    break;
		default:
		    sendTo(n.doorNum(), new NeighbourMessage(n , MSG_TYPES.LABE));
		    break;
		}
	    }
	}
    }
/**  send the state (label) to the neighbour.
    * Warning: only RDV and LC2 use this methode ( redefined for LC1).
    * @param neighbour the neighbour door.
    */
    public void sendState(int neighbour){
    	SynObjectRules synob = new SynObjectRules();
	if (synob.isConnected(neighbour))
	    sendTo(neighbour, new StringMessage(getState()));  
    }
   
   /**
    * set the relabeling system.
    * @param rs the new relabeling system.
    */     
    public void setRelSys(RelabelingSystem rs){
	relSys = rs;
    }
    public RelabelingSystem getRelSys(){
	return relSys;
    }
    
    // works with RDV, LC1, and LC2 and supports various options
/** it's the algorithm of simulation of relabeling system. works with RDV, LC1, and LC2 and supports various options
 */
    public void init(){
	int ruleToApply;
	int round = 0;
	int i=0;
	//initialisation du synob et de synal
	SynObjectRules synob = new SynObjectRules();
	synob.init(getArity());
	synal.set(this);
	
	while(synob.run){
	    round++;
	    synob.reset();
	    if (synob.allFinished())
		synob.run=false;
	    else{
		synal.trySynchronize();
	    }
	    ((SynObjectRules) synob).refresh();

	    if(synob.isElected())
		{  /**** Elected node***/
		    //System.out.println("Elu="+getId());
		    /* exchaging states */
		    updateNeigborhoodInfo();
		    /* choosing a rule to apply */
		    ruleToApply = relSys.checkForRule((Star) ((SynObjectRules) synob).neighbourhood.clone());
		    /* applying the rule */
			if( ruleToApply != -1 ){
			    int kindOfRule = applyRule(ruleToApply);
			    sendUpdate();
			    synal.breakSynchro();  
			    if(relSys.userPreferences.manageTerm)
				endRuleAction(kindOfRule);
			}
			else{
			    sendUpdate();
			    synal.breakSynchro();
			}
			
		    }
		else if(synob.isNotInStar())
		    {
			//System.out.println(getId()+"Not in");
			if(synob.allFinished()){
			    for(i = 0; i < synob.arity; i++){
				if (! synob.hasFinished(i)) {
				    sendTo(i, new IntegerMessage(SynCT.GLOBAL_END, 
								 MSG_TYPES.TERM));
				}
			    }
			    synob.run = false;
			}
		    }
		else if(synob.isInStar())
		    {
			sendMyState();
			// i receive the update 
			receiveAndUpdateMyState();
			if (synob.allFinished()) {
			    for(i = 0; i < synob.arity; i++){
				if (! synob.hasFinished(i)) {
				    sendTo(i, new IntegerMessage(SynCT.GLOBAL_END,
								 MSG_TYPES.TERM));
				}
			    }
			    synob.run = false;
			}
		    }    
	}
    }


    
   /** this method do actions depending of the kind of the rule. 
    *
    * @param kindOfRule possible values defined in class SynCT.
    */ 
    public void endRuleAction(int kindOfRule){
    	switch(kindOfRule){
	case (SynCT.GLOBAL_END) :{
	    for(int i = 0; i < synob.arity; i++){
		if (! synob.hasFinished(i)) {
		    synob.setFinished(i,true);
		    sendTo(i,new IntegerMessage(SynCT.GLOBAL_END, 
						MSG_TYPES.TERM));
		}
	    }
	    synob.run = false;
	    break;
	}
	case (SynCT.LOCAL_END):{
	    for(int i = 0; i < synob.arity ; i++){
		if (! synob.hasFinished(i)) {
		    sendTo(i, new IntegerMessage(SynCT.LOCAL_END, MSG_TYPES.TERM));
		}
	    }
	    synob.run = false;
	    break;
	}
	}
    }
    /* for RDV LC2,but  LC1 should redefine it */ 
    /**
    * send the label to the star center if he is connected.
    * in LC1 they are many centers, so this methode is redefined in LC1Rule.
    */ 
    public void sendMyState(){
	//System.out.println("LC2 ou rdv");
	if (synob.isConnected(synob.center))
	    sendTo(synob.center,new StringMessage(((String) getProperty("label")),MSG_TYPES.LABE));
    }
    /* for RDV LC2, only LC1 should redefine it */     
   public void receiveAndUpdateMyState(){
       if (synob.isConnected(synob.center)) {
	   Message m = receiveFrom(synob.center); 
	   if (m != null) {
	       NeighbourMessage msg = (NeighbourMessage) m;
	       setMyState(msg.label());
	       //marking the Arrow;
	       setDoorState(new MarkedState(msg.mark()), synob.center);
	       synob.setMark(synob.center, msg.mark());
	   }
       }
   }
    /**
    * get user preferences
    * @return the RSOptions
    */      
    public RSOptions getRSOptions(){
	return relSys.userPreferences;
    }
    /**
    * return the label of the node.
    */
    public String getState(){
	return (String) getProperty("label");
    }
    
    public void setMyState(String newState){
	putProperty("label", newState);
    }
/** this methode applies the rule on psition i. the contexts is in synob, modifications are also done in synob.
    *
    * @param i position of the rule.
    * @return 
    */
    public int applyRule(int i){
	int retour;

	Rule r =(Rule) relSys.getRule(i).clone();
	retour = r.getType();
	Star b = new Star(r.befor());
	Star a =(Star) r.after().clone();
	
	if (((Star) ((SynObjectRules)synob).neighbourhood.clone()).contains(b)){
	    a.setDoors(b);
	    ((SynObjectRules)synob).neighbourhood.setStates(a);
	}
	else{
	    //lever exception
	    //System.out.println("regle non app");
	}
	return retour;
    }
    /**
    * get help about the relabeling system
    */
    public String getDescription() {
	return relSys.getDescription();
    }
    
    //PFA2003
    public boolean isRunning() {
	return synob.run;
    }
}
