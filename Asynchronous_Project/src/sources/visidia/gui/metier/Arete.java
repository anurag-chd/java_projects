package sources.visidia.gui.metier;

import sources.visidia.gui.donnees.conteneurs.monde.Position;
import sources.visidia.gui.presentation.AreteDessin;


/** Implements an edge */
public class Arete extends ObjetGraphe implements Cloneable{

  // instance variables

    /** the vertex origin of the edge */
  protected Sommet origine;
    /** the vertex destination of the edge */
  protected Sommet destination;

  // protected variables
  Position position;

   
  // Constructeur.

  /**
   * construct a new edge in un_graphe
   * precising the two vertices origin and destination
   **/
  public Arete(Graphe gr,Sommet origine, Sommet destination) {
      this.graph = gr;
      this.origine = origine;
      this.destination = destination;
      position = graph.edges.ajouterElement(this);
      origine.successeurs.inserer(destination);
      destination.predecesseurs.inserer(origine);
      origine.aretes_sortantes.inserer(this);
      destination.aretes_entrantes.inserer(this);
  }
 
  //  Cloneable Methods.

  /**
   * duplicate the current vertex
   * with origin and destination for vertices at extremity
   **/
  public Object cloner(Sommet origine, Sommet destination) {
    //    assert(origine.graphe() == destination.graphe() == graphe)
    try {
      Arete le_clone = (Arete)super.clone();
      le_clone.graph = origine.graphe();
      le_clone.position = le_clone.graph.edges.ajouterElement(le_clone);
      le_clone.origine = origine;
      le_clone.destination = destination;
      origine.successeurs.inserer(destination);
      destination.predecesseurs.inserer(origine);
      origine.aretes_sortantes.inserer(le_clone);
      destination.aretes_entrantes.inserer(le_clone);
      return le_clone;
    } catch(CloneNotSupportedException e) {
      return null;
    }
  }

  /**
   * duplicate the 2 vertices of the edge and create a new edge
   **/
  public Object cloner() {
    return cloner((Sommet)origine.cloner(), (Sommet)destination.cloner());
  }

  protected Object clone() {
    return cloner();
  }


  // GraphObject method

  /**
   * delete the edge
   **/
  public void supprimer() {
      origine.aretes_sortantes.supprimer(this);
    destination.aretes_entrantes.supprimer(this);
    origine.successeurs.supprimer(destination);
    destination.predecesseurs.supprimer(origine);
    position.supprimerElement();
  }


  /**
   * add the edge in its graph
   **/
  public void ajouter() {
    position = graph.edges.ajouterElement(this);
    origine.successeurs.inserer(destination);
    destination.predecesseurs.inserer(origine);
    origine.aretes_sortantes.inserer(this);
    destination.aretes_entrantes.inserer(this);
  }    

  /**
   * return the origin vertex
   **/
  public Sommet origine() {
    return origine;
  }

  /**
   * return the destination vertex
   **/
  public Sommet destination() {
    return destination;
  }

  /**
     returns the other vertex of the edge ... (un_sommet is a vertex of the edge)
   **/

  public Sommet sommetOppose(Sommet un_sommet) {
    return ((un_sommet == origine) ? destination : origine);
  }

  /**
   * tests if "un_sommet" vertex if the origin of the edge
   **/
  public boolean aPourOrigine(Sommet un_sommet) {
    return (origine == un_sommet);
  }

  /**
   * tests if "un_sommet" vertex if the destination of the edge
   **/
  public boolean aPourDestination(Sommet un_sommet) {
    return (destination == un_sommet);
  }

  /**
   * tests if the edge is incident to the parameter vertex
   **/
  public boolean estIncidenteA(Sommet un_sommet) {
    return ((origine == un_sommet) || (destination == un_sommet));
  }

  /**
   * Changing the origin of the current edge
   *
   **/

  public void changerOrigine(Sommet nouvelleOrigine) {
    origine.aretes_sortantes.supprimer(this);
    origine.successeurs.supprimer(destination);
    nouvelleOrigine.aretes_sortantes.inserer(this);
    nouvelleOrigine.successeurs.inserer(destination);
    destination.predecesseurs.supprimer(origine);
    destination.predecesseurs.inserer(nouvelleOrigine);
    origine = nouvelleOrigine;
  }

  /**
   * 
   * Changing the destination of the current edge
   **/

  public void changerDestination(Sommet nouvelleDestination) {
    destination.aretes_entrantes.supprimer(this);
    destination.predecesseurs.supprimer(origine);
    nouvelleDestination.aretes_entrantes.inserer(this);
    nouvelleDestination.predecesseurs.inserer(origine);
    origine.successeurs.supprimer(destination);
    origine.successeurs.inserer(nouvelleDestination);
    destination = nouvelleDestination;
  }

     // accessor and modificator of the associated view
    
    public void setAreteDessin(AreteDessin a){
	formeDessin = a;}

    public AreteDessin getAreteDessin(){
	return ((AreteDessin)formeDessin);
    }
   
}




