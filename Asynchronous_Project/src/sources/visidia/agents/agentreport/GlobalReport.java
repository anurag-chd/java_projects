package sources.visidia.agents.agentreport;

import sources.visidia.simulation.agents.AbstractStatReport;
import sources.visidia.tools.Bag;

/**
 * My  aim is to  render all  the events.  I'm the  simplest statistic
 * report.
 */
public class GlobalReport extends AbstractStatReport {

    /**
     * Returns all the events that occurred.
     */
    public Bag getStats() {
        return getBag();
    }
}
