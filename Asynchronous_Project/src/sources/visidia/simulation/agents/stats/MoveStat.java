package sources.visidia.simulation.agents.stats;


/**
 * Implements an event  to remember how many times an  agent moves.
 */
public class MoveStat extends AbstractAgentStat {

    public MoveStat(Class agClass) {
        super(agClass);
    }

    public String descriptionName() {
	return "Moves";
    }
}
