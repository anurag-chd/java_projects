package sources.visidia.simulation.agents;

import sources.visidia.rule.Neighbour;
import sources.visidia.rule.RelabelingSystem;
import sources.visidia.rule.Rule;
import sources.visidia.rule.Star;
import sources.visidia.simulation.SimulationAbortError;


public class AgentRules extends AbstractAgentsRules {

    private int v,u;
    private String labelV, labelU;
    private int door;
    private int step;

    public void init(){

        step = 1;

	while (true) {

            if (lockVertexIfPossible()) {
                v = getVertexIdentity();
                labelV = (String)getVertexProperty("label");
                step = 1;

                randomMove();

		u = getVertexIdentity();

                if (lockVertexIfPossible()) {
                    labelU = (String)getVertexProperty("label");
                    door = entryDoor();
                
                    applyRule();
                    unlockVertexProperties();
                }

                moveBack();
                unlockVertexProperties();
	    }
	    else {
                waitForWB();
            }
            nextPulse();
            randomWalk();
        }
    }

    public String toString() {
        switch (step) {
        case 1: return "Construct star";
        case 2: return "No rule";
        case 3: return "Apply rule";
        case 4: return "End application";
        case 5: return "Search new center";
        }
        throw new RuntimeException("This step does not exist!");
    }

    private void applyRule() {
        Star contextStar = contextStar();
        RelabelingSystem rSys = getRelabelling();
        int i = rSys.checkForRule(contextStar);

        if (i == -1) {
            step = 2;
        }
        else {
            step = 3;
            Rule rule = rSys.getRule(i);
            Star afterStar = rule.after();
            Neighbour neighbourV = afterStar.neighbour(0);
            setVertexProperty("label",neighbourV.state());
            moveBack();
            setVertexProperty("label",afterStar.centerState());
            moveBack();        
            
            if (neighbourV.mark())
                markDoor(door);
            
            step = 4;
        }
    }

    private Star contextStar() {
        Star star = new Star(labelV);
        Neighbour nebV = new Neighbour(labelU);
        star.addNeighbour(nebV);
        return star;
    }

    private void waitForWB() {
        while (vertexPropertiesLocked()) {
            try {
                synchronized (this) {
                    wait(1000);
                } 
            } catch (InterruptedException e) {
                throw new SimulationAbortError(e);
            }
        }
    }

    private void randomMove() {
	setAgentMover("RandomAgentMover");
	move();
    }

    private void randomWalk() {
        step = 5;
	setAgentMover("RandomWalk");
	move();
    }
}

