package sources.visidia.tools;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import sources.visidia.gui.donnees.PropertyTableModel;



/**
 * lancer cette classe directement avec java et elle vous donnera des
 * informations sur votre système
 *
 */
public class PropertyEditor extends JTable {
	
    public static void main(String[] args){
    	PropertyTableModel model = new PropertyTableModel(System.getProperties());
    	JTable table = new JTable();
    	table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	JScrollPane spane = new JScrollPane(table);
    	JFrame frame = new JFrame("System Properties");
    	frame.getContentPane().add(spane);
    	frame.pack();
    	frame.setVisible(true);
	frame.addWindowListener(new java.awt.event.WindowAdapter() {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		};
	});
    }
}
