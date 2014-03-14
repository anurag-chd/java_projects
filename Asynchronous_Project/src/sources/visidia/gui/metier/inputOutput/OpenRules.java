package sources.visidia.gui.metier.inputOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import sources.visidia.gui.presentation.userInterfaceSimulation.FenetreDeSimulation;

/**
   Opening saved rules from directories
 */

public class OpenRules implements Serializable{
    
    /** open a file for rules in the current simulator */
    public static void open(FenetreDeSimulation  fenetre){
		
	Vector listeDeRegle;
	File file_open = null;
	JFileChooser fc = new JFileChooser(".");    
	int returnVal = fc.showOpenDialog(fenetre);
	if(returnVal == JFileChooser.APPROVE_OPTION)
	    file_open = fc.getSelectedFile();
	
	// a name file was specified 
	String file_name = fc.getName(file_open);
	if(file_name == null) {
	    return;
	}
	
	try{		
	    
	    File f = new File(fc.getCurrentDirectory(), file_name);
	    FileInputStream fI = new FileInputStream(f);
	    ObjectInputStream oI = new ObjectInputStream(fI);
	    
	/*    if(fenetre.numberOfRules() != 1) {
		Object[] options = {"Save and open",
				    "Open",
				    "Cancel"};*/
		/*int n = JOptionPane.showOptionDialog(fenetre,
						     "Do you want to save before opening a new file ?",
						     "Warning", 
						     JOptionPane.YES_NO_CANCEL_OPTION,
						     JOptionPane.WARNING_MESSAGE,
						     null,
						     options,
						     options[0]);*/
		/*if (n == JOptionPane.YES_OPTION)
		    SaveRules.save(fenetre, fenetre.regles());
		if (n == JOptionPane.CANCEL_OPTION)
		    return;
	    }*/
	    
	    listeDeRegle = (Vector)oI.readObject();	
	   // fenetre.changeRules(listeDeRegle);
	    fenetre.pack();
	    fenetre.setVisible(true);
	    oI.close();
	    fI.close();	
	    
	}
	catch(OptionalDataException e){
	    System.out.println("Exception caught :" + e);
	}
	catch(ClassNotFoundException e){
	    System.out.println("Exception caught :" + e);
	}
	catch(IOException e){
	    System.out.println("Exception caught :" + e);
	}
    }
    
    
	
}







