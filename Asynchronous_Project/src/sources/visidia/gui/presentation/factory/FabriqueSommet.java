package sources.visidia.gui.presentation.factory;

import sources.visidia.gui.metier.Sommet;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.VueGraphe;

public interface FabriqueSommet{

    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label, Sommet s);
    
    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label);
    
    public String description();
    
}
