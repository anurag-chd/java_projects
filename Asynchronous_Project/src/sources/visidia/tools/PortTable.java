package sources.visidia.tools;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

import sources.visidia.network.NodeInterfaceTry;


public class PortTable implements Serializable {
    private Hashtable hash;
    
    public PortTable() {
	hash = new Hashtable();
    }

    public PortTable(Hashtable hash) {
	this.hash = hash;
    }

    public int size() {
	return hash.size();
    }

    public void put(Integer door, Integer neighbor, NodeInterfaceTry neighborStub){
	Vector v = new Vector();
	v.addElement(neighbor);
	v.addElement(neighborStub);
	hash.put(door,v);
    }

    public Integer getNeighbor(Integer door) {
	return (Integer)((Vector)hash.get(door)).elementAt(0);
    }

    public int getDoor(Integer neighbor){
	boolean bool = true;
	int i=0;
	for(;i<hash.size() && bool;i++) {
	    if ((getNeighbor(new Integer(i))).equals(neighbor)){
		bool=false;
	    }
	}
	return i-1;
    }

    public NodeInterfaceTry getNeighborStub(Integer door) {
	return (NodeInterfaceTry)((Vector)hash.get(door)).elementAt(1);
    }

    public Vector getElement(Integer door) {
	return (Vector)hash.get(door);
    }

}
