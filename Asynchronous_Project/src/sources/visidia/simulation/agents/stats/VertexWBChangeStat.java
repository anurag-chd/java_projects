package sources.visidia.simulation.agents.stats;


/**
 * Remembers how many time an agent modified a vertex whiteboard.
 */
public class VertexWBChangeStat extends AbstractAgentStat {

    public VertexWBChangeStat(Class agClass) {
        super(agClass);
    }

    public String descriptionName() {
	return "Vertex WB changes";
    }
}
