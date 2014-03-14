package sources.visidia.gui.presentation.boite;

import sources.visidia.gui.donnees.conteneurs.MultiEnsemble;
import sources.visidia.gui.presentation.SelectionDessin;
import sources.visidia.gui.presentation.userInterfaceSimulation.AgentsSimulationWindow;

/** Cette boite affiche les caracteristiques d'une sélection
 * d'éléments du graphe courant.*/
public class AgentBoxSimulationSelection extends BoiteSelection {
    
    SelectionDessin selection;

    public AgentBoxSimulationSelection(AgentsSimulationWindow parent, 
				    SelectionDessin selection, 
				    MultiEnsemble table_types) {
	super(parent, selection.nbElements (), table_types);
	this.selection = selection;
    }
    
    public static void show(AgentsSimulationWindow parent, SelectionDessin selection, 
			    MultiEnsemble table_types) {
	BoiteSelection b = new AgentBoxSimulationSelection(parent, selection, table_types);
	b.showDialog();
    }

}


