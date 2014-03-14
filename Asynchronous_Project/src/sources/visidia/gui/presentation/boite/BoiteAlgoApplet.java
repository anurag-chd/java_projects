package sources.visidia.gui.presentation.boite;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import sources.visidia.gui.metier.inputOutput.OpenAlgoApplet;
import sources.visidia.gui.presentation.userInterfaceSimulation.FenetreDeSimulation;

/**
 * This class creates a dialog box that load algorithms from an applet     
*/
public class BoiteAlgoApplet implements ActionListener  {

    /** La fenetre parent : la boite sera centree sur cette fenetre.*/
    protected FenetreDeSimulation parent;
    /** Le JDialog dans lequel on va tout afficher.*/
    protected JDialog dialog;
    /** Le bouton Cancel */
    protected JButton buttonCancel;
    /** Le bouton Open */
    protected JButton buttonOpen;
    /** La table d'algo */
    protected JList liste; 
    /* enumeration de sommets */
    protected Enumeration enumOfVertices = null;

    // Constructeurs
    
    public BoiteAlgoApplet(FenetreDeSimulation fenetre, Vector tableAlgo){
	this(fenetre, tableAlgo, "Loading algorithms");
    }

    // ouverture de la boite opour une enumeration de sommets
    public BoiteAlgoApplet(FenetreDeSimulation fenetre, Vector tableAlgo, Enumeration enumOfVertices){
	this(fenetre, tableAlgo, "Loading algorithms for vertices");
	this.enumOfVertices = enumOfVertices;
    }

    public BoiteAlgoApplet(FenetreDeSimulation fenetre, Vector tableAlgo, String titre){
	parent = fenetre;
	dialog = new JDialog(parent, titre);

	liste = new JList(tableAlgo);
	liste.setSize(600,400);
	
	JScrollPane listScrollPane = new JScrollPane(liste);
	
	//dialog.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));
	dialog.getContentPane().setLayout(new BorderLayout());
	dialog.getContentPane().add(listScrollPane, BorderLayout.CENTER);
	dialog.setSize(600,400);
	
	ajouterBoutons();
	dialog.setVisible(true);
    }


    /** Affiche la boite et la centre par rapport a "parent".*/
    public void show() {
	dialog.pack();
	dialog.show();
	dialog.setLocationRelativeTo(null);
    }


    public void ajouterBoutons() {
	JPanel buttonPane = new JPanel(new FlowLayout());
	
	buttonOpen = new JButton("Open");
	buttonOpen.addActionListener(this);
	
	buttonCancel = new JButton("Cancel");
	buttonCancel.addActionListener(this);
	
	
	buttonPane.add(buttonOpen);
	buttonPane.add(buttonCancel);    
	
	dialog.getContentPane().add(buttonPane, BorderLayout.SOUTH);
    }
    

    public void actionPerformed(ActionEvent e) {
	if(e.getSource() == buttonOpen) {
	    try {
		if (enumOfVertices == null)
		    OpenAlgoApplet.setAlgorithm((String)(liste.getSelectedValue()));
		else 
		    OpenAlgoApplet.setAlgorithmForVertices((String)(liste.getSelectedValue()),enumOfVertices);
		dialog.setVisible(false);
		dialog.dispose();
	    } catch(NumberFormatException exception) {
		StringTokenizer st =
		    new StringTokenizer(exception.getMessage(), "\n");
		int nb_lignes = st.countTokens();
		String message = new String();
		for(int i = 0; i < nb_lignes; i++)
		    message = message + "\n" + st.nextToken();
		JOptionPane.showMessageDialog(parent,
					      message, 
					      "Warning",
					      JOptionPane.WARNING_MESSAGE);
	    }
	}
	
	if(e.getSource() == buttonCancel) {
	    dialog.setVisible(false);
	    dialog.dispose();
	}
    }
    
}
    
