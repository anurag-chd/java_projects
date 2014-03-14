package sources.visidia.gui.presentation.userInterfaceEdition.undo;

import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SelectionDessin;

/** Cette classe permet d'annuler et de restaurer les séléctions
 * d'objets dans le graphe. */

public class SelectFormeDessin implements UndoObject {
    
  SelectionDessin selection;
  FormeDessin forme;
  
  /** Construit une nouvelle forme correspondant à la séléction de
   * forme de selection */ 
  public SelectFormeDessin(SelectionDessin selection, FormeDessin forme) {
    this.selection = selection;
    this.forme = forme;
  }
  
  public void undo() {
    forme.enluminer(false);
    selection.supprimerElement(forme);
  }
    
  public void redo() {
    forme.enluminer(true);
    selection.insererElement(forme);
  }

  public FormeDessin content() {
      return forme;
  }

}
  
