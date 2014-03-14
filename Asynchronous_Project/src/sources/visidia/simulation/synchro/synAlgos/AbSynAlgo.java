package sources.visidia.simulation.synchro.synAlgos;

import java.util.Collection;
import java.util.LinkedList;

import sources.visidia.misc.MSG_TYPES;
import sources.visidia.misc.SyncState;
import sources.visidia.rule.Star;
import sources.visidia.simulation.Algorithm;
import sources.visidia.simulation.synchro.synObj.SynObjectRules;
//
/** all synchronisation algorithms should extend this class
    *
    */

public abstract class AbSynAlgo extends Algorithm implements IntSynchronization
{
  
    protected int answer[];
        
    public AbSynAlgo(){
	super();
    }
  

    public Collection getListTypes(){
	Collection typesList = new LinkedList();
        typesList.add(MSG_TYPES.SYNC);
	typesList.add(MSG_TYPES.TERM);
	return typesList;
    }
	    
    public void setNeighbourhood(Star neighbourhood)
    {
	((SynObjectRules)synob).setNeighbourhood(neighbourhood);
    }
    abstract  public Object clone();
    
    
    public String toString(){
	return "Abstract Synchro";
    }
    public void init(){
    }
/**
 *  breaks synchronisation.
 * in fact it informs the gui.
 */
    public void breakSynchro() {
	for( int door = 0; door < getArity(); door++){
            setDoorState(new SyncState(false),door);
        }
    }
    
}    






