package sources.visidia.gui.presentation.factory;

import java.io.Serializable;

import sources.visidia.gui.metier.Sommet;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.SommetRoutage;
import sources.visidia.gui.presentation.VueGraphe;

public class FabriqueSommetRoutage implements FabriqueSommet,Serializable{
 
    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label, Sommet s){
	return new SommetRoutage(vg,x,y,label,s);
    }

    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label){
	return new SommetRoutage(vg,x,y,label);
    }
    
    public String description(){
    	return "Routing vertex type";}
}
