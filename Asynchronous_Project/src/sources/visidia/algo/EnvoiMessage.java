package sources.visidia.algo;
import sources.visidia.misc.StringMessage;
import sources.visidia.simulation.Algorithm;

public class EnvoiMessage extends Algorithm {

    public void init(){

	for(int i = 1; i<=1000000 ; i++){
	    sendTo(0, new StringMessage("Hello"));
	    try{
		Thread.sleep(600);
	    } catch (Exception e) {
	    }
	}
    }
    
    public Object clone(){
        return new EnvoiMessage();
    }
}
