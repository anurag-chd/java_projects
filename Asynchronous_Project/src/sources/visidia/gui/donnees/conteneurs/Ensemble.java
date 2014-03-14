package sources.visidia.gui.donnees.conteneurs;

import java.io.*;
import java.util.*;

/**
 * Cette classe implémente un ensemble d'objets. Chacun d'entre eux
 * n'est présent qu'une fois dans l'ensemble.  Les méthodes "equals"
 * et "hashCode" des objets sont utilisées.
 **/
public class Ensemble implements Cloneable, Serializable {

    // Variables d'instance.

    protected Hashtable table;
    
    // Constructeurs.

    /**
     * Crée un Ensemble vide.
     **/
    public Ensemble() {
	table = new Hashtable();
    }

    /**
     * Crée un Ensemble avec une table de hachage donnée.
     * Utilisé par clone.
     **/
    protected Ensemble(Hashtable table) {
	this.table = table;
    }

  

    // Méthodes.

    /**
     * Nombre d'éléments contenus dans l'ensemble.
     **/
    public int taille() {
	return table.size();
    }

    /**
     * Teste si l'ensemble est vide.
     **/
    public boolean estVide() {
	return table.isEmpty();
    }

    /**
     * Insère un objet dans l'ensemble. Si l'objet est déjà présent,
     * rien ne se passe.  "un_objet" ne doit pas être "null".
     **/
    public void inserer(Object un_objet) {
	// Remarque: le deuxieme argument de la methode "put" n'est pas utilise
	// On peut mettre n'importe quoi dedant
	table.put(un_objet, un_objet);
    }

    /**
     * Insère une enumeration d'objets dans l'ensemble. Si un de ces
     * objet est deja present, rien ne se passe. Aucun objet ne doit
     * etre "null".
     **/
    public void inserer(Enumeration e) {
	while(e.hasMoreElements())
	    inserer(e.nextElement());
    }

    /**
     * Supprime un objet de l'ensemble. Si l'objet n'est pas présent,
     * rien ne se passe.
     **/
    public void supprimer(Object un_objet) {
	table.remove(un_objet);
    }

    /**
     * Supprime tous les éléments de l'ensemble.
     **/
    public void vider() {
	table.clear();
    }

    /**
     * Teste si un objet est présent dans l'ensemble.
     **/
    public boolean contient(Object un_objet) {
	return table.containsKey(un_objet);
    }

    /**
     * Fait une copie independante. Ne clone pas les éléments.
     **/
    public Object clone() {
	return new Ensemble((Hashtable)table.clone());
    }

    /**
     * Retourne une enumeration de tous les éléments de l'ensemble.
     **/
    public Enumeration elements() {
	return table.keys();
    }

    /**
     * Ajoute tous les elements de un_ensemble a l'ensemble courant.
     **/
    public void union(Ensemble un_ensemble) {
	Enumeration e = un_ensemble.table.keys();

	while(e.hasMoreElements())
	    inserer(e.nextElement());
    }

    /**
     * Teste si un_ensemble est inclus dans l'ensemble courant.
     * Les éléments sont comparés avec leurs méthodes equals().
     **/
    public boolean inclut(Ensemble un_ensemble) {
	Enumeration e = un_ensemble.table.keys();
	while(e.hasMoreElements())
	    if(!table.containsKey(e.nextElement()))
		return false;
	return true;
    }

    /**
     * Teste l'égalité du contenu de l'ensemble courant et de un_ensemble.
     * Les éléments sont comparés avec leurs methodes equals().
     **/
    public boolean estEgalA(Ensemble un_ensemble) {
	return ((table.size() == un_ensemble.table.size()) &&
		inclut(un_ensemble));
    }

}
