package alchemyAPI.src.com.alchemyapi.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import twitter4j.Status;
import twitterSentimentMining.Solution;
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI;
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI_KeywordParams;
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI_NamedEntityParams;
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI_TargetedSentimentParams;

class SentimentTest {
    public static void main(String[] args) throws IOException, SAXException,
            ParserConfigurationException, XPathExpressionException {
        // Create an AlchemyAPI object.
    	 //AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("C://Users/Anurag/Downloads/AlchemyAPI_Java-0.8.tar/AlchemyAPI_Java-0.8/testdir/api_key.txt");
    	 AlchemyAPI alchemyObj1 = AlchemyAPI.GetInstanceFromFile("C://Users/Anurag/Downloads/AlchemyAPI_Java-0.8.tar/AlchemyAPI_Java-0.8/testdir/api_key.txt");
    	 
    	 /*Solution sol = new Solution();
         ArrayList<Status> tweets =sol.generateTweets();
         FileWriter writer = new FileWriter("Anurag_category_test.txt");
         
         for (int i = 0; i < tweets.size(); i++) {
     	    Status t = (Status) tweets.get(i);
     	    Document doc = alchemyObj.TextGetRankedKeywords(t.getText());
     	    writer.write(getStringFromDocument(doc));
         */
       //  Extract sentiment for a web URL.
       /* Document doc = alchemyObj.URLGetTextSentiment("http://www.techcrunch.com/");
       System.out.println(getStringFromDocument(doc));*/

        // Extract sentiment for a text string.
       /*Document doc = alchemyObj.TextGetTextSentiment(
            "That hat is ridiculous, Charles.");
        System.out.println(getStringFromDocument(doc));
*/
        Solution sol = new Solution();
        //String str1= "jtimberlake";
        //String str2= "BillGates";
        //String str3= "BarackObama";
        String str4= "ericschmidt";
        /*ArrayList<Status> tweets1 =sol.generateTweets(str1);
        ArrayList<Status> tweets2 =sol.generateTweets(str2);
        ArrayList<Status> tweets3 =sol.generateTweets(str3);
        ArrayList<Status> tweets4 =sol.generateTweets(str4);
        FileWriter writer = new FileWriter("Anurag_sentiment.txt");*/
        //createFile(str1, alchemyObj1);
        //createFile(str2, alchemyObj1);
        //createFile(str3, alchemyObj1);
        createFile(str4, alchemyObj1);
        /*for (int i = 0; i < tweets.size(); i++) {
    	    Status t = (Status) tweets.get(i);
    	    Document doc = alchemyObj1.TextGetRankedKeywords(t.getText());
    	    System.err.println( "Tweets of times follower @" + t.getUser().getScreenName() + " - " + t.getText()+"~!\n");
    	    writer.write( "Tweets of times follower @" + t.getUser().getScreenName() + " - " + t.getText()+"~!\n");
    	    writer.write(getStringFromDocument(doc));
        }*/
        
        
        // Load a HTML document to analyze.
       /* String htmlDoc = getFileContents("/home/bcard/data/example.html");

        // Extract sentiment for a HTML document.
        doc = alchemyObj.HTMLGetTextSentiment(htmlDoc, "http://www.test.com/");
	System.out.println(getStringFromDocument(doc));
*/	
	// Extract entity-targeted sentiment from a HTML document.	
	/*AlchemyAPI_NamedEntityParams entityParams = new AlchemyAPI_NamedEntityParams();
	entityParams.setSentiment(true);
	doc = alchemyObj.TextGetRankedNamedEntities("That Mike Tyson is such a sweetheart.", entityParams);
	System.out.println(getStringFromDocument(doc));
	
	// Extract keyword-targeted sentiment from a HTML document.	
	AlchemyAPI_KeywordParams keywordParams = new AlchemyAPI_KeywordParams();
	keywordParams.setSentiment(true);
	doc = alchemyObj.TextGetRankedKeywords("That Mike Tyson is such a sweetheart.", keywordParams);
	System.out.println(getStringFromDocument(doc));
    */    
	//Extract Targeted Sentiment from text
	/*AlchemyAPI_TargetedSentimentParams sentimentParams = new AlchemyAPI_TargetedSentimentParams();
	sentimentParams.setShowSourceText(true);
	doc = alchemyObj.TextGetTargetedSentiment("This car is terrible.", "car", sentimentParams);
	System.out.print(getStringFromDocument(doc));
*/
/*	//Extract Targeted Sentiment from url
	doc = alchemyObj.URLGetTargetedSentiment("http://techcrunch.com/2012/03/01/keen-on-anand-rajaraman-how-walmart-wants-to-leapfrog-over-amazon-tctv/", "Walmart",sentimentParams);
	System.out.print(getStringFromDocument(doc));

	//Extract Targeted Sentiment from html
	doc = alchemyObj.HTMLGetTargetedSentiment(htmlDoc, "http://www.test.com/", "WujWuj", sentimentParams);
	System.out.print(getStringFromDocument(doc));*/
}

    
    public static void createFile(String str, AlchemyAPI alchemyObj1) throws IOException, XPathExpressionException, SAXException, ParserConfigurationException
    {
    	Solution sol = new Solution();
    	ArrayList<Status> tweets =sol.generateTweets(str);
    	FileWriter writer = new FileWriter(str+"_sentiment3.xml");
    	writer.write( "<?xml version=\"1.0\"?>\n");
    	writer.write( "<Sentiment-Minning>");
    	for (int i = 0; i < tweets.size(); i++) {
    	    Status t = (Status) tweets.get(i);
    	    Document doc = alchemyObj1.TextGetTextSentiment(t.getText());
   // 	    Document doc = alchemyObj1.TextGetRankedKeywords(t.getText());
    	    Document doc1 = alchemyObj1.TextGetCategory(t.getText());
    	    System.err.println( "Tweets of times follower @" + t.getUser().getScreenName() + " - " + t.getText()+"~!\n");
    	   // writer.write( "\nTweets of times follower @" + t.getUser().getScreenName() + " - " + t.getText()+"~!\n");
    	    
    	    writer.write( "<tweet id = \""+t.getUser().getScreenName()+"\">\n");
    	    writer.write(getStringFromDocument(doc));
    	    writer.write(getStringFromDocument(doc1));
    	    writer.write( "</tweet>\n");
    	    
        }
    	writer.write( "</Sentiment-Minning>");
    }
    // utility function
    private static String getFileContents(String filename)
        throws IOException, FileNotFoundException
    {
        File file = new File(filename);
        StringBuilder contents = new StringBuilder();

        BufferedReader input = new BufferedReader(new FileReader(file));

        try {
            String line = null;

            while ((line = input.readLine()) != null) {
                contents.append(line);
                contents.append(System.getProperty("line.separator"));
            }
        } finally {
            input.close();
        }

        return contents.toString();
    }

    // utility method
    private static String getStringFromDocument(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);

            return writer.toString();
        } catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
