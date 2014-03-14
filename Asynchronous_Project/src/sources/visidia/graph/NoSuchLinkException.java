package sources.visidia.graph;
/**
 * exception levée lorsqu'un client tente de faire une opération
 * sur une arête qui n'existe pas dans le graphe.
 */
public class NoSuchLinkException extends RuntimeException {
    /**
     * fait appel au constructeur <code>super()</code>
     */
    public  NoSuchLinkException(){
	super();
    }

    /**
     * fait appel au constructeur <code>super(s)</code>
     */
    public NoSuchLinkException(String s){
	super(s);
    }
}
