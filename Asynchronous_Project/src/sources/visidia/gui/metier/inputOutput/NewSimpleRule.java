package sources.visidia.gui.metier.inputOutput;

import sources.visidia.gui.presentation.boite.BoiteSimpleRule;
import sources.visidia.gui.presentation.userInterfaceSimulation.FenetreDeSimulation;

public class NewSimpleRule{
    
 public static void newRule(FenetreDeSimulation fenetre) {
	
	BoiteSimpleRule boiteSimpleRule = new BoiteSimpleRule(fenetre,"Regle Numero" );
        boiteSimpleRule.show(fenetre);
	
		

 	fenetre.pack();
 	fenetre.setVisible(true);
  }
    
}
