package sources.visidia.agents;

import sources.visidia.simulation.agents.Agent;

/**
 * Agents to  demonstrate how moveBack() is working.   It simply moves
 * to  a  door   and  then  back  to  the   previous  vertex  for  all
 * neighboors. It marks the visited edges too. <p>
 *
 * As a result, a star is drawn.
 *
 * @see Agent#moveBack()
 * @see Agent#markDoor(int)
 */
public class MovingBack extends Agent {

    protected void init() {

	for(int i = 0; i < getArity(); ++i) {
	    moveToDoor(i);
	    moveBack();

            /**
             * Puts the edge associated with the door i in bold.
             */
            markDoor(i);
	}
    }
}
