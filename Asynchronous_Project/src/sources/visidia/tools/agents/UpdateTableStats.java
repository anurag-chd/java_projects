package sources.visidia.tools.agents;

import sources.visidia.simulation.agents.AbstractStatReport;
import sources.visidia.simulation.agents.AgentSimulator;
import sources.visidia.tools.Bag;
import sources.visidia.tools.HashTableModel;

public class UpdateTableStats extends UpdateTable {

    AgentSimulator sim;
    AbstractStatReport expType;

    public UpdateTableStats(AgentSimulator sim, AbstractStatReport expType, 
                            HashTableModel table, long sleepTime) {
        super(table,sleepTime);
        this.sim = sim;
	this.expType = expType;
    }

    public UpdateTableStats(AgentSimulator sim, AbstractStatReport expType, 
			    HashTableModel table) {
        this(sim, expType, table, 1000);
    }

    public void setTableModel(HashTableModel table) {
        this.table = table;
    }

    public void setStatReport(AbstractStatReport report) {
        this.expType = report;
    }

    public void run() {
        while (! stop) {
            try {
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                stop();
            }
	    expType.setStats(sim.getStats());
	    Bag stats = expType.getStats();
	    if (stats != null)
		((HashTableModel)table).setProperties(stats.asHashTable());
        }
    }

}
