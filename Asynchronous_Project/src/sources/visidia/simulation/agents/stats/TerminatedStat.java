package sources.visidia.simulation.agents.stats;


/**
 * Remembers how many algorithms finished their work.
 */
public class TerminatedStat extends AbstractAgentStat {

    public TerminatedStat(Class agClass) {
        super(agClass);
    }

    public String descriptionName() {
	return "Terminated algorithms";
    }
}
