package sources.visidia.gui.presentation.userInterfaceSimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import sources.visidia.misc.MessageType;

//this class will allow us to choose which messages we want to
//visualize in the graphical interface.

public class MessageChoiceDist  extends JMenu implements ActionListener {
    protected FenetreDeSimulationDist fenetre;
    //private AlgoChoice algoChoice;
    // the menu depend on the choice of algorithm which determine 
    // exactly the different types of messages exchanged 
    private Collection menusNames;
    //private LinkedList checkBoxes;
    
    
    public MessageChoiceDist(FenetreDeSimulationDist parent){
        super("Message Types");
	this.fenetre=parent;
	//before choosing any algo from the list
        //if (algoChoice.getTableAlgo().isEmpty())
	//  menusNames = new LinkedList();
    }
    
    public void setListTypes(Hashtable ht) {
	removeAll();
	
	Collection lt = ht.values();
	menusNames=lt;
        Iterator it=lt.iterator();
	while(it.hasNext()){
            MessageType messageType = (MessageType)it.next();
            JCheckBoxMenuItem checkBox=new JMessageTypeMenuItem(messageType);
            add(checkBox);
            checkBox.addActionListener(this);
            checkBox.setState(messageType.getToPaint());
        }	
    }
    
    public void actionPerformed(ActionEvent evt){
	JMessageTypeMenuItem checkBox=(JMessageTypeMenuItem)evt.getSource();
	try {
	    this.fenetre.setMessageType(checkBox.getMessageType(),checkBox.isSelected());
	} catch (Exception e) {
	    System.out.println("Erreur dans MessageChoiceDist : "+e);
	    e.printStackTrace();
	}
    }
}
