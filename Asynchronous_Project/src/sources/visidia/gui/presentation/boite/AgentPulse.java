package sources.visidia.gui.presentation.boite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JLabel;


public class AgentPulse extends JLabel implements ActionListener, Serializable {

    int pulse;
    
    public AgentPulse() {
	super();
	initState();
    }
    

    public void initState() {
	pulse = 0;
	setPulse(pulse);
	setEnabled(false);
    }
    
    public void setPulse(int pulse) {
	if(!isEnabled())
	    setEnabled(true);
	setText("Pulse Counter : " + String.valueOf(pulse));
    }

    public void actionPerformed(ActionEvent e) {}


}
