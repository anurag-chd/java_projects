package sources.visidia.gui.presentation.userInterfaceEdition.undo;

import sources.visidia.gui.presentation.FormeDessin;
import sources.visidia.gui.presentation.SelectionDessin;

/** Cette classe permet d'annuler et de restaurer les deselections des
 * formes dans le graphe. */

public class DeselectFormeDessin implements UndoObject {
    
  protected SelectionDessin selection;
  protected FormeDessin forme;

  /** Construit une nouvelle forme correspondant a la deselection de
   * forme de selection */ 
  public DeselectFormeDessin(SelectionDessin selection, FormeDessin forme) {
    this.selection = selection;
    this.forme = forme;
  }
  
  public void undo() {
    forme.enluminer(true);
    selection.insererElement(forme);
  }
    
  public void redo() {
    forme.enluminer(false);
    selection.supprimerElement(forme);
  }

  public FormeDessin content() {
      return forme;
  }
}
  
