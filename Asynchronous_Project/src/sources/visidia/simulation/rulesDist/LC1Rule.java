package sources.visidia.simulation.rulesDist;

import sources.visidia.misc.BooleanMessage;
import sources.visidia.misc.MSG_TYPES;
import sources.visidia.misc.MarkedState;
import sources.visidia.misc.Message;
import sources.visidia.misc.StringMessage;
import sources.visidia.rule.RelabelingSystem;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synAlgosDist.LC1;

public class LC1Rule extends AbstractRuleDist {
 public LC1Rule() {
	super();
	synType = SynCT.LC1;
	LC1 synal = new LC1();
	addMessageType(MSG_TYPES.MARK);
    }
    public LC1Rule(RelabelingSystem r){ 
	super(r);
	synType = SynCT.LC1;
	LC1 synal = new LC1();
	addMessageType(MSG_TYPES.MARK);
    }
    
    public Object clone(){
	LC1Rule algo = new LC1Rule();
	algo.copy(this);
	return algo;
    }
    public String toString(){
	return ("RSAlgo: synal="+this.synType+" opt="+relSys.userPreferences.toString()+"\n RS="+relSys.toString());    
    }
    /****** commun avec centralisee *****/
   /* for LC1 */
    public void sendMyState(){
	for(int i=0; i<  synob.getCenters().size(); i++) {
	    int door = ((Integer)  synob.getCenters().elementAt(i)).intValue();
	    if (synob.isConnected(door)) {
		sendTo(door,new StringMessage(((String) getProperty("label")),MSG_TYPES.LABE));
	    }
	}
    }
    /* for LC1 */
    public void receiveAndUpdateMyState(){
	for(int i=0;i<  synob.getCenters().size();i++){
	    int neighbour = ((Integer) synob.getCenters().elementAt(i)).intValue();
	    if(synob.isConnected(neighbour)){
		Message msg = receiveFrom(neighbour);
		if(msg != null){
		    setDoorState(new MarkedState(((BooleanMessage)msg).data()), neighbour);
		    synob.setMark(neighbour,((BooleanMessage)msg).data());
		}
	    }
	}
    }
}


