package sources.visidia.simulation.agents; 

import sources.visidia.rule.RelabelingSystem;
    
public abstract class AbstractAgentsRules extends SynchronizedAgent {
    
    private RelabelingSystem rSys = null;

    public void setRule(RelabelingSystem rSys) {
	this.rSys = rSys;
    }
    
    protected RelabelingSystem getRelabelling() {
        return rSys;
    }
}
