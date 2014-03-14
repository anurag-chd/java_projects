package sources.visidia.gui.presentation.userInterfaceEdition.undo;

import sources.visidia.gui.presentation.AreteDessin;
import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SommetDessin;

/** Cette classe permet d'annuler et de restaurer les deselections des
 * formes dans le graphe. */

public class ChangeFormeDessin implements UndoObject {
    
    protected FormeDessin ancienne_forme;
    protected FormeDessin nouvelle_forme;

  /** Construit une nouvelle forme correspondant à la deselection de
   * forme de selection */ 
  public ChangeFormeDessin(FormeDessin ancienne, FormeDessin nouvelle) {
    this.ancienne_forme = ancienne;
    this.nouvelle_forme = nouvelle;
  }
  
  public void undo() {
      nouvelle_forme.getVueGraphe().insererListeAffichage(ancienne_forme);
      ancienne_forme.setObjetGraphe(nouvelle_forme.getObjetGraphe());
      miseAJourModel(ancienne_forme);
      nouvelle_forme.getVueGraphe().supprimerListeAffichage(nouvelle_forme);
  }
    
  public void redo() {
      ancienne_forme.getVueGraphe().insererListeAffichage(nouvelle_forme);
      nouvelle_forme.setObjetGraphe(ancienne_forme.getObjetGraphe());
      miseAJourModel(nouvelle_forme);
      ancienne_forme.getVueGraphe().supprimerListeAffichage(ancienne_forme);
  }

  private void miseAJourModel(FormeDessin f){
      if (f.type().equals("vertex"))
	  ((SommetDessin)f).getSommet().setSommetDessin((SommetDessin)f);
      else if (f.type().equals("edge"))
	  ((AreteDessin)f).getArete().setAreteDessin((AreteDessin)f);
  }
      

  public FormeDessin content() {
      return ancienne_forme;
  }
}
  
