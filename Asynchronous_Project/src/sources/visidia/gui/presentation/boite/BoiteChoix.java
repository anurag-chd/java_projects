package sources.visidia.gui.presentation.boite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import sources.visidia.gui.donnees.TableCouleurs;
import sources.visidia.gui.presentation.userInterfaceEdition.Editeur;



/**
 * Cette classe cree une boite utilisée pour afficher et modifier    
 * la table des correspondances etat-couleur                         
 */
public class BoiteChoix implements ActionListener {
    
    /** La fenêtre parent : la boite sera centrée sur cette fenêetre.*/
    protected Editeur parent;
    /** Le JDialog dans lequel on va tout afficher.*/
    protected JDialog dialog;
     /** Le bouton Ok*/
    protected JButton buttonOk;
    /** Le bouton Cancel*/
    protected JButton buttonCancel;
    /** la table des couples couleur-etat */
    protected Hashtable dico;
    protected ReglePanel plancheDeCouleurs;
    protected Color couleur ;
    
    
    //Constructeurs
    public BoiteChoix(Editeur parent, String titre) {
	
	this.dialog = new JDialog(parent, titre);
	this.parent = parent;
      	this.dico = TableCouleurs.getTableCouleurs() ;
	plancheDeCouleurs = new ReglePanel( dico , this);
	
	dialog.getContentPane().setLayout(new BorderLayout());
	dialog.getContentPane().add(plancheDeCouleurs, BorderLayout.NORTH);
	
	ajouterBoutons(); 
	
    }
    //Methodes
    /** Affiche la boite et la centre par rapport a "parent".*/
    public void show(Frame parent) {
	dialog.pack();
	dialog.show();
	dialog.setLocationRelativeTo(parent);
    }
    
    /** Ajoute un bouton nomme "label" au panel "pane" */
    public JButton addButton(JPanel pane, String label) {
	JPanel tmp = new JPanel(new FlowLayout());
	JButton button = new JButton(label);
	tmp.add(button);
	button.setSize(button.getMinimumSize());
	pane.add(tmp);
	pane.add(Box.createRigidArea(new Dimension(0, 5)));
	return button;
    }
    
    
    /**
     * Ajoute les boutons en bas de la boite. Suivant "est_editable", 
     * certains d'entre eux seront actifs ou non.                     
     */
    public void ajouterBoutons() {
    JPanel buttonPane = new JPanel(new FlowLayout());
    
    buttonOk = new JButton("Ok");
    buttonOk.addActionListener(this);
    
    buttonCancel = new JButton("Cancel");
    buttonCancel.addActionListener(this);

    buttonPane.add(buttonOk);
    buttonPane.add(buttonCancel);    
    dialog.getContentPane().add(buttonPane, BorderLayout.SOUTH);
  }
  

  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == buttonOk) {
     	dialog.setVisible(false);
        dialog.dispose();
    }
   
    if(e.getSource() == buttonCancel) {
      dialog.setVisible(false);
      dialog.dispose();
    }
  }
    
 
  /** Retourne le JDialog. */
  public JDialog dialog() {
    return dialog;
  }
}











