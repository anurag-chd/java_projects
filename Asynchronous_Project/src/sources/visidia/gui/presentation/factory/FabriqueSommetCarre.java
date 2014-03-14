package sources.visidia.gui.presentation.factory;

import java.io.Serializable;

import sources.visidia.gui.metier.Sommet;
import sources.visidia.gui.presentation.SommetCarre;
import sources.visidia.gui.presentation.SommetDessin;
import sources.visidia.gui.presentation.VueGraphe;

public class FabriqueSommetCarre implements FabriqueSommet,Serializable{
 
    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label, Sommet s){
	return new SommetCarre(vg,x,y,label,s);
    }

    public SommetDessin creerSommet(VueGraphe vg, int x, int y, String label){
	return new SommetCarre(vg,x,y,label);
    }
    
    public String description(){
    	return "Simple vertex";}
}
