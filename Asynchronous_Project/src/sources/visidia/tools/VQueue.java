package sources.visidia.tools;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.*;

/**
 * A VQueue object implements a FIFO (First In First Out) list. It can be used in multi-threads
 * environment since all it's methods are synchronized. The get (resp. put) method blocks when
 * there is no element to return (resp. when the queue contains maxSize elements). If the calling
 * thread is interrupted while it is blocked in these methods, the <code>InterruptedException</code>
 * is thrown.  
 */
public class VQueue{
    /**
     * taille maximale de la file d'attente.
     */
    private int maxSize;  

    /* La structure stockant la file de messages*/
    private LinkedList queue;

    /**
     * Constructs a queue with default maximum size which is Integer.MAX_VALUE.
     */
    public VQueue(){
	this(Integer.MAX_VALUE);
    }

    /**
     *  Constructs a queue with maximum size <code>maxSize</code>
     */
    public VQueue(int maxSize){
	this.maxSize = maxSize;
	queue = new LinkedList();
    }

    /**
     * Return the first element in the queue. if the queue is empty, this method block
     * until an element is available.
     */
    public synchronized Object get() throws InterruptedException{
	while( queue.isEmpty() ){
	    wait();
	}
	notifyAll();
	return queue.removeFirst();
    }
    
    /**
     * Return the first element in the queue that match the criterion <code>c</code>.
     * If the queue does not contains any element that match the criterion <code>c</code>,
     * this method block until one that macth <code>c</code> be available. 
     */
    public synchronized Object get(Criterion c) throws InterruptedException{
	while(true){
	    ListIterator li = queue.listIterator();
	    while( li.hasNext() ){
		Object o = li.next();
		if( c.isMatchedBy(o) ){
		    li.remove();
		    return o;
		}
	    }
	    wait();
	}
    }
    
    
    /**
     * Return the first element in the queue that match the criterion <code>c</code>.
     * If the queue does not contains any element that match the criterion <code>c</code>,
     * this method returns null. 
     */
    public synchronized Object getNoWait(Criterion c) throws InterruptedException{
	ListIterator li = queue.listIterator();
	while( li.hasNext() ){
	    Object o = li.next();
	    if( c.isMatchedBy(o) ){
		li.remove();
		return o;
	    }
	}
	
	return null;
    }

    /**
     * Return all elements in the queue that match the criterion <code>c</code>.
     * If the queue does not contains any element that match the criterion <code>c</code>,
     * this method returns null. 
     */
    public synchronized Vector getAllNoWait(Criterion c) throws InterruptedException{
	Vector v = new Vector();
	ListIterator li = queue.listIterator();
	while( li.hasNext() ){
	    Object o = li.next();
	    if( c.isMatchedBy(o) ){
		li.remove();
		v.addElement(o);
	    }
	}
	if (v.size() == 0)
	    return null;
	else return v;
    }    
    /** 
     * Add one element at the end of the queue. If the queue contanis <code>maxSize</code>
     * elements this method block until one element be consumed.
     */
    public synchronized void put(Object obj)throws InterruptedException{
	while( queue.size() >= maxSize ){
	    //System.out.println("Echec Pile pleine");
	    //System.out.println("Nouvelle Tentative");
	    wait();
	}
	//System.out.println("message ajoute");
	queue.addLast(obj);
	notifyAll();
    }
    
    /**
     * Return true if the queue is empty.
     */
    public synchronized boolean isEmpty(){
	return queue.isEmpty();
    }
    
    /**
     * Returns true if the queue contains one element that match the criterion c.
     */
    public synchronized boolean contains(Criterion c){
	ListIterator li = queue.listIterator();
	while( li.hasNext() ){
	    Object o = li.next();
	    if( c.isMatchedBy(o) ){
		return true;
	    }
	}
	return false;
    }	

    /**
     * remove all elements from the queue.
     */
    public synchronized void purge(){
	queue = new LinkedList();
    }
	
    /**
     * return this queue maximum size.
     */
    public int getMaxSize(){
	return maxSize;
    }
    
    /**
     * Do not use this method if your are not sure about what you are doing.
     * It notifies all threads waiting on a new entry in the queue
     **/
    
    public synchronized void notifyAllGet() {
	notifyAll();
    }
    
}
