package sources.visidia.gui.donnees;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

/**
 * Class that maps properties (key, value) entries into
 * a double column table model.
 */ 
public abstract class AbstractPropertyTableModel extends AbstractTableModel {

    protected Vector keys = null;

    protected final int nameColumn = 0;
    protected final int typeColumn = 1;
    protected final int valueColumn = 2;

    
    /**
     * Constructs new empty property table model.
     */
    public AbstractPropertyTableModel(){
       
    }

 
    abstract public void putProperty(String key, Object value);


    abstract public void removeProperty(int row);

    public Class getColumnClass(int col){
        return String.class;
    }
    
    public int getColumnCount(){
        return 3;
    }
    
    public int getRowCount(){
        return keys.size();
    }
    
    protected String getTypeName(Object obj) {

	String class_name = obj.getClass().getName();

	return class_name.substring(class_name.lastIndexOf('.')+1);
    }
    
    abstract public Object getValueAt(int row, int col);
    
    /**
     * Only value column cell are editable.
     */
    public boolean isCellEditable(int row, int col) {
        Object obj = getValueAt(row,col);

        return ((col == valueColumn) && (!keys.elementAt(row).equals("label"))
                               && (( obj instanceof String)
                                   || ( obj instanceof Integer)
                                   || ( obj instanceof Double)
                                   || ( obj instanceof Float)
                                   || ( obj instanceof Boolean)
                                   || ( obj instanceof Long)
                                   || ( obj instanceof Short)
                                   || ( obj instanceof Byte) 
                                   || ( obj instanceof Character)));
    }


    public String getColumnName(int col){
        switch(col){
        case 0: return "name";
        case 1: return "type";
        case 2: return "value";
        }
        throw new IllegalArgumentException();	
    }
    
    /**
     * Sets row value to <code>aValue</code>.
     */ 
    abstract public void setValueAt(Object aValue, int row, int col);

}
