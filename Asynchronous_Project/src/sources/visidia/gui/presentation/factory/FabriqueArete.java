package sources.visidia.gui.presentation.factory;

import sources.visidia.gui.metier.Arete;
import sources.visidia.gui.presentation.AreteDessin;
import sources.visidia.gui.presentation.SommetDessin;

public interface FabriqueArete{

    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination, Arete a);

    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination);
    
    public String description();
    
}
