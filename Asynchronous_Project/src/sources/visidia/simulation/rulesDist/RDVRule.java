
package sources.visidia.simulation.rulesDist;

import sources.visidia.misc.MSG_TYPES;
import sources.visidia.rule.RelabelingSystem;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synAlgosDist.RDV;



public class RDVRule extends AbstractRuleDist{
    
    public RDVRule() {
	super();
	synType = SynCT.RDV;
	synal = new RDV();
	addMessageType(MSG_TYPES.MARK);
    }
    public RDVRule(RelabelingSystem r){ 
	super(r);
	synType = SynCT.RDV;
	synal = new RDV();
	addMessageType(MSG_TYPES.MARK);
    }
    
    public Object clone(){
	RDVRule algo = new RDVRule();
	algo.copy(this);
	return algo;
    }
    public String toString(){
	return "RDVRule"+super.toString();    
    } 

}
