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

public class KeywordTest {
    public static void main(String[] args) throws IOException, SAXException,
            ParserConfigurationException, XPathExpressionException {
        // Create an AlchemyAPI object.
        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("C://Users/Anurag/Downloads/AlchemyAPI_Java-0.8.tar/AlchemyAPI_Java-0.8/testdir/api_key.txt");

        // Extract topic keywords for a web URL.
       /* Document doc = alchemyObj.URLGetRankedKeywords("C://Users/Anurag/workspace/twitterSentimentMining/Anurag.txt");
        System.out.println(getStringFromDocument(doc));*/

        // Extract topic keywords for a text string.
        Solution sol = new Solution();
        ArrayList<Status> tweets =sol.generateTweets();
        FileWriter writer = new FileWriter("Anurag_response.txt");
        
        for (int i = 0; i < tweets.size(); i++) {
    	    Status t = (Status) tweets.get(i);
    	    Document doc = alchemyObj.TextGetRankedKeywords(t.getText());
    	    writer.write(getStringFromDocument(doc));
        }
    	 writer.close();
    	    		
    	    		
    	    		
        /*Document doc = alchemyObj.TextGetRankedKeywords(
            "Twwets of times follower @sayardhiren63 - Cricketers are also human being so naturally they will help others when they find them in pain.........!!!!! http://t.co/LW1xaFbG5R?~!Twwets of times follower @wlvrn_tjs - RT @offstumped: Should try increasing the escape velocity RT @timesofindia: Rahul Gandhi's UP rallies get dull response http://t.co/BVlCUQS…~!Twwets of times follower @snniyappa - RT @TOIBangalore: Buses can't carry cargo in hold http://t.co/K2jHDSb6x7~!Twwets of times follower @the_poet_ABI - RT @timesofindia: No info on Kalam’s letter on mercy pleas, govt says http://t.co/lOZX9Jq72v~!.  " );
        System.out.println(getStringFromDocument(doc));*/

        // Load a HTML document to analyze.
        /*String htmlDoc = getFileContents("data/example.html");

        // Extract topic keywords for a HTML document.
        doc = alchemyObj.HTMLGetRankedKeywords(htmlDoc, "http://www.test.com/");
        System.out.println(getStringFromDocument(doc));*/
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
