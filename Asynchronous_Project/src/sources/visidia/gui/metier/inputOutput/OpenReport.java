package sources.visidia.gui.metier.inputOutput;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Constructor;

import javax.swing.JFileChooser;

import sources.visidia.gui.presentation.userInterfaceSimulation.AgentsSimulationWindow;
import sources.visidia.simulation.agents.AbstractStatReport;

public class OpenReport implements Serializable{

    protected static final String dir = new String("visidia/agents/agentreport");
    
    public static AbstractStatReport open(AgentsSimulationWindow window){

        File file_open = null; 
        JFileChooser fc = new JFileChooser(dir);
        javax.swing.filechooser.FileFilter classFileFilter = 
            new FileFilterClass();
        fc.addChoosableFileFilter(classFileFilter);
        fc.setFileFilter(classFileFilter);
      
        int returnVal = fc.showOpenDialog(window);
        if(returnVal == JFileChooser.APPROVE_OPTION)
            file_open = fc.getSelectedFile();
      
        String file_name = fc.getName(file_open);
        if (file_name == null) 
            return null ; // if canceled
        window.mettreAJourTitreFenetre(file_name);
      
        int index = file_name.lastIndexOf('.');
        String className = "visidia.agents.agentreport." 
            + file_name.substring(0,index);
	
	AbstractStatReport stat;
	try {
	    Class classStats = Class.forName(className);
	    Constructor constructor = classStats.getConstructor();
	    stat = (AbstractStatReport)constructor.newInstance();
	    
	} catch(Exception excpt) {
	    throw new RuntimeException("The agent chooser can't be created",
				       excpt);
	}
	return stat;
    }
}
