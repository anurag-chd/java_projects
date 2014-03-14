package sources.visidia.simulation.rules;

import sources.visidia.rule.RelabelingSystem;
import sources.visidia.simulation.synchro.SynCT;
import sources.visidia.simulation.synchro.synAlgos.LC2;
 
public class LC2Rule extends AbstractRule {
    
    public LC2Rule() {
	super();
	synType = SynCT.LC2;
	synal = new LC2();
    }
    public LC2Rule(RelabelingSystem r){ 
	super(r);
	synType = SynCT.LC2;
	synal = new LC2();
    }
    
    public Object clone(){
	LC2Rule algo = new LC2Rule();
	algo.copy(this);
	return algo;
    }
    public String toString(){
	return "LC2Rule"+super.toString();    
    } 
}



    	







