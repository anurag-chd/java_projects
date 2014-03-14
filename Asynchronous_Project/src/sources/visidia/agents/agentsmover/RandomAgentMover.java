package sources.visidia.agents.agentsmover;

import java.util.Random;

import sources.visidia.simulation.agents.Agent;
import sources.visidia.simulation.agents.AgentMover;

/**
 * Provides a random move for an Agent. On a vertex, the agent goes to
 * a random door.
 */
public class RandomAgentMover extends AgentMover {
    
    public RandomAgentMover(Agent ag) {
        super(ag);
    }

    protected int findNextDoor() {
        Random rand = new Random();

        return rand.nextInt(agent().getArity());
    }
}
