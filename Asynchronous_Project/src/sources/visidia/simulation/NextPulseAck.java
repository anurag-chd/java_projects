package sources.visidia.simulation;

import java.io.Serializable;

/**
 * NextPulseAck object is used to acknowledge the next pulse event :
 * the SimulEventHandler has finished to handle all event occuring at
 * the current phase
 */
public class NextPulseAck implements  SimulAck, Serializable{
    private long num;
    
    public NextPulseAck(Long evtNumber){
	num = evtNumber.longValue();
    }

    /**
     * return the acknowledgement number.
     */
    public Long number(){
	return new Long(num);
    }

    /**
     * return SimulConstants.NEXT_PULSE as acknowledgement type.
     */
    public int type(){
	return SimulConstants.NEXT_PULSE;
    }
}
