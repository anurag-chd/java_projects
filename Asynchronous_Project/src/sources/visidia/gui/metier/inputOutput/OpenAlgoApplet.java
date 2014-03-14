package sources.visidia.gui.metier.inputOutput;

import java.io.Serializable;
import java.util.Enumeration;

import sources.visidia.gui.donnees.TableAlgo;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.boite.BoiteAlgoApplet;
import sources.visidia.gui.presentation.userInterfaceSimulation.FenetreDeSimulation;

public class OpenAlgoApplet implements Serializable{
 
    public static FenetreDeSimulation fenetre;

    /** 
     *
	Open ".class" file for a simulation algorithm from the applet
	the algorithm is affected to all the vertices
    */
    public static void open(FenetreDeSimulation fenet){
	fenetre= fenet;
	BoiteAlgoApplet box = new BoiteAlgoApplet(fenetre,TableAlgo.getKeys());
	box.show();
    }

    
    
    public static void setAlgorithm(String key){
	try {
	    fenetre.getAlgorithms().putAlgorithmToAllVertices(TableAlgo.getAlgo(key));
	    fenetre. getMenuChoice(). setListTypes((TableAlgo.getAlgo(key)).getListTypes());
	    System.err.println("Changement du menu reussi\n");
	}
	catch(Exception excpt) {
	    System.out.println("Problem: " + excpt);
	}
    }

    /*
     * OPENING ALGORITHM FOR AN ENUMERATION OF VERTICES
     *
     */



    public static void openForVertices(Enumeration vertices,FenetreDeSimulation fenet){
	fenetre= fenet;
	BoiteAlgoApplet box = new BoiteAlgoApplet(fenetre,TableAlgo.getKeys(),vertices);
	box.show();
    }

    public static void setAlgorithmForVertices(String key,Enumeration e){
	try {
	    String id;
	    while (e.hasMoreElements()){
		id = ((SommetDessin)e.nextElement()).getEtiquette();
		fenetre.getAlgorithms().putAlgorithm(id, TableAlgo.getAlgo(key));
		fenetre. getMenuChoice(). addAtListTypes((TableAlgo.getAlgo(key)).getListTypes());
	    }
	}
	catch(Exception excpt) {
	    System.out.println("Problem: " + excpt);
	}
    }
    
}



