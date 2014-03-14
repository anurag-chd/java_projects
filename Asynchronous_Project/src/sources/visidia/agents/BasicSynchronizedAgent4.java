package sources.visidia.agents;

import sources.visidia.simulation.agents.SynchronizedAgent;

/**
 * I wait  1.88 seconds between  each move and  I move 4  times before
 * dying.
 *
 * @see BasicSynchronizedAgent1
 */
public class BasicSynchronizedAgent4 extends SynchronizedAgent {

    protected void init() {
        
        setAgentMover("RandomAgentMover");

        for (int i=0; i < 4; ++i) {
	    sleep(1880);
	    nextPulse();
            move();
	}
    }
}
