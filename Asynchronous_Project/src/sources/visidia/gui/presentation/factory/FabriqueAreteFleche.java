package sources.visidia.gui.presentation.factory;

import java.io.Serializable;

import sources.visidia.gui.metier.Arete;
import sources.visidia.gui.presentation.AreteDessin;
import sources.visidia.gui.presentation.AreteFlecheSimple;
import sources.visidia.gui.presentation.SommetDessin;

public class FabriqueAreteFleche implements FabriqueArete,Serializable{

 
    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination, Arete a){
	return new AreteFlecheSimple(origine, destination, a);
    }

    
    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination){
	return new AreteFlecheSimple(origine, destination);
    }
    
    public String description(){
    	return "Oriented edge";}

}
