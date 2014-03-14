package sources.visidia.gui.presentation.boite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import sources.visidia.gui.donnees.AgentPropertyTableModel;
import sources.visidia.gui.presentation.userInterfaceSimulation.AgentsSimulationWindow;
import sources.visidia.tools.agents.UpdateTableAgent;
import sources.visidia.tools.agents.WhiteBoard;



/**
 * Cette classe cree une boite utilisee pour modifier l'etat d'un    
 * ou de plusieurs sommets selectionne elle est appelee quand on ne    
 * selectionne que des sommets et qu'on appui sur le bouton info     
*/
public class AgentBoxProperty
    extends AbstractDefaultBox
    implements ActionListener, ItemListener, VueEtatPanel
{

    UpdateTableAgent timer;

    //Constructeurs

    public AgentBoxProperty(AgentsSimulationWindow parent, WhiteBoard wb, String agentName) {
        this(parent,wb, "Agent property for " + agentName, agentName );
    }

    /**
     * Cree une nouvelle boite appelee "titre" pour afficher les
     * caracteristiques de "un_objet".
     */
    public AgentBoxProperty(AgentsSimulationWindow parent, WhiteBoard wb, String titre, String agentName) 
    {
        super(parent,titre,false);
        
        tbModel = new AgentPropertyTableModel(wb);
        
        table.setModel(tbModel);

	dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
		closingWindow();
	    }
	    });

        timer = new UpdateTableAgent( (AgentPropertyTableModel) tbModel);
        new Thread(timer).start();

    }

    //Methodes  
    
    public void updateBox() {
        System.out.println("AgentBoxProperty.updateBox()");
        tbModel.fireTableDataChanged();
    }

    public void closingWindow(){
	parent.removeWindow(this);
	close();
    }
    
    public void close() {
	timer.stop();
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == buttonDone) {
            closingWindow();

            dialog.setVisible(false);
            dialog.dispose();
        }
        if(e.getSource() == buttonAdd) {
            
            
            Object[] possibilities = {"String", "Integer|int", "Byte", "Character|char",
                                      "Double|double","Float|float", "Long|long", 
                                      "Short|short", "Boolean|boolean"};
            
            Object objValue;
            
            String s = (String) JOptionPane.showInputDialog(parent,
                                                            "Select the type:",
                                                            "Type",
                                                            JOptionPane.PLAIN_MESSAGE,
                                                            null,
                                                            possibilities,
                                                            "String");
            
            //If a string was returned, say so.
            if ((s != null) && (s.length() > 0)) {
                
                String name = JOptionPane.showInputDialog(parent, "Enter the name :");
                String value = JOptionPane.showInputDialog(parent, "Enter the value :");
                
                if ( name != null  && value != null )
                    {
                        objValue = value;

                        try{

                            if      ( s.equals("Integer|int") ) {objValue = new Integer(value); }
                            else if ( s.equals("Byte") ) {objValue = new Byte(value);}
                            else if ( s.equals("Character|char") ) {objValue = new Character(value.charAt(0));}
                            else if ( s.equals("Double|double") ) {objValue = new Double(value);}
                            else if ( s.equals("Float|float") ) {objValue = new Float(value);}
                            else if ( s.equals("Long|long") ) {objValue = new Long(value);}
                            else if ( s.equals("Short|short") ) {objValue = new Short(value);}
                            else if ( s.equals("Boolean|boolean") ) {objValue = new Boolean(value);}

                            tbModel.putProperty(name,objValue);
                        }
                        catch(Exception e2) {
                            JOptionPane.showMessageDialog(null,
                                          e2.getMessage(), 
                                          "Warning",
                                          JOptionPane.WARNING_MESSAGE); 
                        }
                    }
            }
            
        }
        if(e.getSource() == buttonRemove) {
            
            if (table.getSelectedRow() == -1 ) {
                JOptionPane.showMessageDialog(parent,
                                              "No property selected !", 
                                              "Warning",
                                              JOptionPane.WARNING_MESSAGE);
            }
            else {
                tbModel.removeProperty(table.getSelectedRow());
            }
            
        }
        
    }


    


}

