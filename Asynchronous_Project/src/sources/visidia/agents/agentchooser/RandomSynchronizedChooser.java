package sources.visidia.agents.agentchooser;

import java.util.Random;

/**
 * Places synchronized  agents randomly on the  graph. The probability
 * to add a  new agent is 0.7  on each vertex.  The agents  to add are
 * choosen randomly between the 4 basic synchronized agents.
 *
 * @see visidia.agents.BasicSynchronizedAgent1
 * @see visidia.agents.BasicSynchronizedAgent2
 * @see visidia.agents.BasicSynchronizedAgent3
 * @see visidia.agents.BasicSynchronizedAgent4
 */
public class RandomSynchronizedChooser extends RandomAgentChooser {

    /**
     * Randomly chooses one of the four basic synchronized agents.
     *
     * @return "BasicSynchronizedAgent<i>" where <i> is an int between
     * 1 and 4.
     */
    protected String agentName() {
        Random generator = new Random();
        int value = generator.nextInt(4) + 1;

        return "BasicSynchronizedAgent" + value;
    }

    /**
     * Probability of adding an agent on a vertex.
     *
     * @return 0.7
     */
    protected float probability() {
        return (float)0.7;
    }

}
