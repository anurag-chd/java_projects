package sources.visidia.gui.presentation.userInterfaceEdition.undo;


import java.util.Enumeration;
import java.util.Vector;

import sources.visidia.gui.metier.Arete;
import sources.visidia.gui.presentation.AreteDessin;
import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SommetDessin;

/** Cette classe contient les informations pour annuler les fusions de
 * sommets intervenant lors du deplacement d'un sommet existant : il
 * faut pouvoir recreer le sommet qui est detruit lors la fusion, lui
 * redonner sa position initiale, et reaffecter les extrémites des
 * arêtes.
 **/
public class FusionneSommet implements UndoObject {
    
    /**
     *le sommet qui sera detruit par la fusion(le sommet qu'on deplace) 
     **/
    protected SommetDessin sommetDetruit;
    /**
     * le sommet sur lequel est realise la fusion.
     **/ 
    protected SommetDessin sommetGarde; 
   
    private Vector aretesEntrantes;
    
    private Vector aretesSortantes;  
    
    /** 
     * l'abscisse initiale du sommet detruit.
     */
	protected int original_X; 
    /**
     *l'ordonnée initiale du sommet detruit.
     **/
    protected int original_Y; 
  
    public FusionneSommet(SommetDessin sommetDetruit,
			  SommetDessin sommetGarde,
			  int original_X,
			  int original_Y) {
	this.sommetDetruit = sommetDetruit;
	this.sommetGarde = sommetGarde;
	aretesEntrantes = new Vector();
	aretesSortantes = new Vector();
	Enumeration e = sommetDetruit.getSommet().aretesEntrantes();
	while (e.hasMoreElements()) {
	    this.aretesEntrantes.addElement(((Arete)e.nextElement()).getAreteDessin());
	}
	e = (sommetDetruit.getSommet()).aretesSortantes();
	while (e.hasMoreElements()) {
	    this.aretesSortantes.addElement(((Arete)e.nextElement()).getAreteDessin());
	}
	this.original_X = original_X;
	this.original_Y = original_Y;
    }
  
    public void undo() {
	sommetDetruit.getVueGraphe().putObject(sommetDetruit);
	int i;
	for (i=0; i<aretesSortantes.size(); i++) {
	    ((AreteDessin)aretesSortantes.elementAt(i)).changerOrigine(sommetDetruit);
	}
	for (i=0; i<aretesEntrantes.size(); i++) {
	    ((AreteDessin)aretesEntrantes.elementAt(i)).changerDestination(sommetDetruit);
	}
	sommetDetruit.placer(original_X, original_Y);
    }


    public void redo() {
	int i;
	for (i=0; i<aretesSortantes.size(); i++) {
	    ((AreteDessin)aretesSortantes.elementAt(i)).changerOrigine(sommetGarde);
	}
	for (i=0; i<aretesEntrantes.size(); i++) {
	    ((AreteDessin)aretesEntrantes.elementAt(i)).changerDestination(sommetGarde);
	}
	sommetDetruit.getVueGraphe().delObject(sommetDetruit);
    }

    public FormeDessin content() {
	return sommetDetruit;
    }
}
