package sources.visidia.gui.presentation.boite;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import sources.visidia.gui.donnees.conteneurs.MultiEnsemble;
import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SelectionDessin;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.userInterfaceSimulation.FenetreDeSimulationDist;

/** Cette boite affiche les caracteristiques d'une sélections
 * d'éléments du graphe courant.*/
public class BoiteSelectionSimulationDist extends BoiteSelection {
    
    SelectionDessin selection;

    public BoiteSelectionSimulationDist(FenetreDeSimulationDist parent, 
					SelectionDessin selection, 
					MultiEnsemble table_types) {
	super(parent, selection.nbElements (), table_types);
	this.selection = selection;
    }
    
    public static void show(FenetreDeSimulationDist parent, SelectionDessin selection, 
			    MultiEnsemble table_types) {
	BoiteSelection b = new BoiteSelectionSimulationDist (parent, selection, 
							     table_types);
	b.showDialog();
    }

    public JComponent createContent() {
	
	JComponent mainPane = super.createContent();
	
	//JPanel firstPane = new JPanel ();
	JPanel secPane = new JPanel ();
	
	mainPane.setLayout(new GridLayout(2, 1));
	//mainPane.add(firstPane);
	mainPane.add(secPane);
      
	//BoxLayout firstLayout = new BoxLayout(firstPane, BoxLayout.Y_AXIS);
	BoxLayout secLayout = new BoxLayout(secPane, BoxLayout.Y_AXIS);
	secPane.setLayout(secLayout);
	
	secPane.setBorder(BorderFactory.createTitledBorder
			  (BorderFactory.createEtchedBorder(),
			   "Drawing messages properties"));
	
	boolean vertexSelected = false;
	Enumeration tous_les_types = table_types.elements();
	while(tous_les_types.hasMoreElements()) {
	    String un_type = (String)tous_les_types.nextElement();
	    if (un_type.equals ("vertex"))
		vertexSelected = true;
	}
	final JCheckBox drawMessageCheckBox = new JCheckBox("Draw messages");
	secPane.add(drawMessageCheckBox);
	drawMessageCheckBox.setEnabled(vertexSelected);
	
	JButton applyButton = new JButton("Apply");
	JPanel applyPane = new JPanel (new FlowLayout (FlowLayout.CENTER));
	applyPane.add(applyButton);
	applyButton.addMouseListener (new MouseAdapter() {
		public void mouseClicked(MouseEvent event) {
		    boolean isSelected = drawMessageCheckBox.isSelected();
		    Enumeration e = selection.elements();
		    while (e.hasMoreElements()) {
			FormeDessin element = ((FormeDessin) e.nextElement());
			if (element.type().equals("vertex")) {
			    SommetDessin vertex = (SommetDessin) element;
			    int id = new Integer (vertex.getEtiquette()).intValue ();
			    Hashtable prop = vertex.getStateTable();
			    prop.put ("draw messages", isSelected ? "yes" : "no");
			    ((FenetreDeSimulationDist) parent).nodeStateChanged
				(id, (Hashtable) prop.clone()); 
			    vertex.setDrawMessage(isSelected);
			}
		    }
		}
	    });
	secPane.add(applyPane);
	
	return mainPane;
    }
}


