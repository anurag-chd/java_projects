import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class HelloRDFWorld {
	public static void main(String args[]){
		String personUri = "http://somewhere/Anurag";
		String given_name = "Anurag";
		String family_name = "Choudhary";
		String full_name = "Anurag Choudhary";
		Model m = ModelFactory.createDefaultModel();
		
		Resource anurag = m.createResource(personUri);
		anurag.addProperty(VCARD.FN,full_name);
		anurag.addProperty(VCARD.N,m.createResource().addProperty(VCARD.Given,given_name).addProperty(VCARD.Family,family_name));
		m.write(System.out);
		//m.write(System.out,"RDF/XML-ABBREV");
		StmtIterator itr = m.listStatements();
		
		while(itr.hasNext()){
		
			Statement st = itr.nextStatement();
			
			Resource subject = st.getSubject();
			Property predicate = st.getPredicate();
			RDFNode object = st.getObject();
			System.out.print(subject.toString());
			System.out.print("    "+predicate.toString()+"    ");
			if(object.isResource()){
				System.out.print(object.toString());
				
			}
			else{
				System.out.print("\"" + object.toString() + "\"");
			}
			System.out.println(" .");
		}
		
	}
}
