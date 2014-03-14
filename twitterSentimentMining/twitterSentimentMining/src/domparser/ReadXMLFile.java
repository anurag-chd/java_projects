package domparser;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadXMLFile {
	
	public static void main(String argv[]) {
		 
	    try {
	    	////yahan se//////////////////
	    	/*
	    	File inFile = new File("C:/Users/Anurag/workspace/twitterSentimentMining/ericschmidt_sentiment3.xml");

	    	  if (!inFile.isFile()) {
	    	    System.out.println("Parameter is not an existing file");
	    	    return;
	    	  }

	    	  //Construct the new file that will later be renamed to the original filename.
	    	  //File tempFile = new File("New_file.txt");

	    	  BufferedReader br = new BufferedReader(new FileReader(inFile));
	    	  //PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
	    	  FileWriter writer = new FileWriter("ericschmidt_sentiment4.xml");
	    	  String line = null;
	    	  String line1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><results>";
	    	  String line2 = "</results><?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><results>";
	    	  String line3 = "<type>neutral</type>";
	    	  //Read from the original file and write to the new
	    	  //unless content matches data to be removed.
	    	  while ((line = br.readLine()) != null ) {

	    	    //if (!line.trim().equals(line1) && !line.trim().equals(line2) ) {
	    	   // System.out.println("hello");
	    		  if(line.trim().equals(line1))
	    			  writer.write("<results>");
	    		  if(line.trim().equals(line3))
	    			  writer.write("<type>neutral</type><score>0.000</score>");
	    		  if (!line.trim().equals(line2) && !line.trim().equals(line1) && !line.trim().equals(line3) ) {
	    		 System.out.println(line);
	    	    writer.write(line);  
	    	   // pw.println(line);
	    	     // pw.flush();
	    	    }
	    	  }
	    	  //writer.write("</Sentiment-Minning>");
	    	  br.close();

	    	  //Delete the original file
	    	  /*if (!inFile.delete()) {
	    	    System.out.println("Could not delete file");
	    	    return;
	    	  }
*/
	    	  //Rename the new file to the filename the original file had.
	    /*	  if (!tempFile.renameTo(inFile))
	    	    System.out.println("Could not rename file");
*/
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	   /* 	
	    	BufferedReader br = new BufferedReader(new FileReader("C:/Users/Anurag/workspace/twitterSentimentMining/BarackObama_sentiment1.xml"));
	    	String line;
	    	int i;
	    	FileWriter writer = new FileWriter("New_sentiment.txt");
	    	while ((line = br.readLine()) != null) {
	    		String trline = line.trim();
	    		if((trline.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>")))
	    		 i=0;
	    		else
	    			writer.write(line);
	    	   // process the line.
	    	}
	    	br.close();
	*/
	    ///////////////Add Sentiment files here    //////////////////	
		File fXmlFile = new File("C:/Users/Anurag/workspace/twitterSentimentMining/ericschmidt_sentiment4.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    //}
		Document doc = dBuilder.parse(fXmlFile);
	 
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("tweet");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
	 
				System.out.println("Tweet id : " + eElement.getAttribute("id"));
				NodeList nList1 = doc.getElementsByTagName("docSentiment");
				Element eElement1 = (Element) nList1.item(temp);
				System.out.println("Sentiment of tweet : " + eElement1.getElementsByTagName("type").item(0).getTextContent());
				System.out.println("Sentiment score of tweet : " + eElement1.getElementsByTagName("score").item(0).getTextContent());
				System.out.println("Category of tweet : " + eElement.getElementsByTagName("category").item(0).getTextContent());
				
			
				//System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				//System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
	// }
			}
	    }
		}
	    catch (FileNotFoundException ex) {
	    
	    	ex.printStackTrace();
	    	}
	    	catch (IOException ex) {
	    	  ex.printStackTrace();
	    	}
	     catch (Exception e) {
		e.printStackTrace();
	    }
	 // }
	 
	}
	}

