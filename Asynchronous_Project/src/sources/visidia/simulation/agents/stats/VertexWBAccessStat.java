package sources.visidia.simulation.agents.stats;


/**
 * Remembers how many times an agent accessed a vertex whiteboard.
 */
public class VertexWBAccessStat extends AbstractAgentStat {

    public VertexWBAccessStat(Class agClass) {
        super(agClass);
    }

    public String descriptionName() {
	return "Vertex WB access";
    }
}
