package sources.visidia.simulation.synchro.synAlgosDist;

import sources.visidia.misc.MSG_TYPES;
import sources.visidia.misc.SyncState;
import sources.visidia.rule.Star;
import sources.visidia.simulation.AlgorithmDist;
import sources.visidia.simulation.synchro.synObj.SynObjectRules;
//


public abstract class AbSynAlgoDist extends AlgorithmDist implements IntSynchronization
{
    protected int answer[];
       
    public AbSynAlgoDist(){
	super();
	addMessageType(MSG_TYPES.SYNC);
	addMessageType(MSG_TYPES.TERM);
	
    }
            
    public void setNeighbourhood(Star neighbourhood)     {
//	SynObjectRules synob = null;
    	SynObjectRules synob = new SynObjectRules();
	((SynObjectRules) synob).setNeighbourhood(neighbourhood);
    }

    abstract public Object clone();
      
    public void init() {
    }
    public void breakSynchro() {
	for( int door = 0; door < getArity(); door++){
            setDoorState(new SyncState(false),door);
        }
    }

    public abstract void trySynchronize();
}
	
    	
    
    





