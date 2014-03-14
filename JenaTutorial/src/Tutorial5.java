import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;

import java.io.*;

/** Tutorial 5 - read RDF XML from a file and write it to standard out
 */
public class Tutorial5 extends Object {

    /**
        NOTE that the file is loaded from the class-path and so requires that
        the data-directory, as well as the directory containing the compiled
        class, must be added to the class-path when running this and
        subsequent examples.
    */    
    static final String inputFileName  = "c:/Users/Anurag/workspace/JenaTutorial/src/koala.owl";
                              
    public static void main (String args[]) {
        // create an empty model
        FileManager.get().addLocatorClassLoader(Tutorial5.class.getClassLoader());
        Model model = FileManager.get().loadModel(inputFileName);
    	//Model model = ModelFactory.createDefaultModel();
        
        String queryString = 
        		"Prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        		"Prefix owl: <http://www.w3.org/2002/07/owl#>" +
        		"SELECT * WHERE {" +
        		" ?person owl:hasValue"+
        		" ?x."+
        		"}";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query,model);
        try{
        	ResultSet results = qexec.execSelect();
        	while(results.hasNext()){
        		QuerySolution sol = results.nextSolution();
        		Resource name = null;	
        		
        		/*if(( sol.getResource("x"))!=null){
        			name = sol.getResource("x");
        			System.out.println(name);
        		}*/
        			
        	//	else{
        		if(sol.getLiteral("x")!=null){
        			System.out.println("Literal present");
        			Resource name1 = sol.getLiteral("x").asResource();
        			System.out.println(name1);
        		}
        		else{
        			System.out.println("Resource present");
        			name = sol.getResource("x");
        			System.out.println(name);
        		}
        		//Literal name = sol.getLiteral("x");
        		
        		
        	}
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        finally{
        	qexec.close();
        }
       /*
        InputStream in = FileManager.get().open( inputFileName );
        if (in == null) {
            throw new IllegalArgumentException( "File: " + inputFileName + " not found");
        }
        
        // read the RDF/XML file
        model.read(in, "");
                    
        
        // write it to standard out
       // model.write(System.out,"N-TRIPLES");
        model.write(System.out);*/
    }
}