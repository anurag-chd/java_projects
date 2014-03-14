package sources.visidia.gui.presentation.factory;

import java.io.Serializable;

import sources.visidia.gui.metier.Arete;
import sources.visidia.gui.presentation.AreteDessin;
import sources.visidia.gui.presentation.AreteSegment;
import sources.visidia.gui.presentation.SommetDessin;

public class FabriqueAreteSegment implements FabriqueArete,Serializable{

    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination, Arete a){
	return new AreteSegment(origine, destination,a);
    }
 
    public AreteDessin creerArete(SommetDessin origine, SommetDessin destination){
	return new AreteSegment(origine, destination);
    }
    
    public String description(){
    	return "Non oriented edge";}
}

