package sources.visidia.simulation.rules;

import sources.visidia.rule.RelabelingSystem;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synAlgos.RDV;
 
public class RDVRule extends AbstractRule{
    
    public RDVRule() {
	super();
	synType = SynCT.RDV;
	synal = new RDV();
    }
    public RDVRule(RelabelingSystem r){ 
	super(r);
	synType = SynCT.RDV;
	synal = new RDV();
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



    	







