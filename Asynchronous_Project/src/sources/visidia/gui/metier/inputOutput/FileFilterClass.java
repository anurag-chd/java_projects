package sources.visidia.gui.metier.inputOutput;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

// this class is the file filter which recognizes the class format (*.class)

public class FileFilterClass extends FileFilter{
    
    public FileFilterClass(){ 
	super();}
    
    public String getDescription(){
	return new String("*.class");}
    
    public boolean accept(File f)	{
	if(f.isDirectory()){
			return true;
	 }
	 
	String s = f.getName();
	int i = s.lastIndexOf('.');
	if (i > 0 &&  i < s.length() - 1) {
	    String extension = s.substring(i+1).toLowerCase();
	    return (extension.equals("class"));
	}
	return false;
    }
    
}
