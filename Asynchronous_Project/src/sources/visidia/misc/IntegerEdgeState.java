package sources.visidia.misc;


/**
 *
 */
public class IntegerEdgeState extends EdgeState{
    private int val;

    public IntegerEdgeState(int value){
	val = value;
    }

    public int value(){
	return val;
    }

    /**
     * crée une copy de cet objet.
     */
    public Object clone(){
	return new IntegerEdgeState(val);
    }
}
