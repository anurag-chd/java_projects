package sources.visidia.gui.presentation.userInterfaceSimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;

import sources.visidia.gui.metier.simulation.AlgoChoice;
import sources.visidia.misc.MessageType;

//this class will allow us to choose which messages we want to
//visualize in the graphical interface.

public class ChoiceMessage2 extends JMenu implements ActionListener {
    /** the menu depend on the choice of algorithm which determine
     * exactly the different types of messages exchanged */
    private AlgoChoice algoChoice;
    
    private Collection menusNames;
        
    
    public ChoiceMessage2(AlgoChoice algoChoice,Collection menusNames){
        this.algoChoice = algoChoice;
        this.menusNames = menusNames;
        setListTypes(menusNames);
        
    }
    
    public ChoiceMessage2(AlgoChoice algoChoice){
        super("Messages Type");
        if (algoChoice.getTableAlgo().isEmpty())//before choosing any algo from the list
            menusNames = new LinkedList();
    }
    
    
    public void setListTypes(Collection lt){
        removeAll();//in order to remove all the previous menu items and set others
        
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
    
    public void addAtListTypes(Collection cl){
        removeAll();
        menusNames.addAll(cl);
        setListTypes(menusNames);
    }
    
    public void actionPerformed(ActionEvent evt){
        JMessageTypeMenuItem checkBox=(JMessageTypeMenuItem)evt.getSource();
        //	String ch=checkBox.getText();
        //	System.out.println("vous avez clique sur la case"+ch);
        checkBox.getMessageType().setToPaint(checkBox.getState());
    }
}
