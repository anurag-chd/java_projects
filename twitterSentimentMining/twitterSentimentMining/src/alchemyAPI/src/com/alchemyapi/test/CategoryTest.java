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
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI_CategoryParams;
import alchemyAPI.src.com.alchemyapi.api.AlchemyAPI_Params;

class CategoryTest {
    public static void main(String[] args)
        throws IOException, SAXException,
               ParserConfigurationException, XPathExpressionException
    {
        // Create an AlchemyAPI object.
        AlchemyAPI alchemyObj = AlchemyAPI.GetInstanceFromFile("C://Users/Anurag/Downloads/AlchemyAPI_Java-0.8.tar/AlchemyAPI_Java-0.8/testdir/api_key.txt");
        
        Solution sol = new Solution();
        ArrayList<Status> tweets =sol.generateTweets("");
        FileWriter writer = new FileWriter("Anurag_category_test.txt");
        
        for (int i = 0; i < tweets.size(); i++) {
    	    Status t = (Status) tweets.get(i);
    	    Document doc = alchemyObj.TextGetCategory(t.getText());
    	    writer.write(getStringFromDocument(doc));
        }
        writer.close();
        
        // Categorize a web URL by topic.
       /* Document doc = alchemyObj.URLGetCategory("http://www.techcrunch.com/");
        System.out.println(getStringFromDocument(doc));

        // Categorize some text.
        doc = alchemyObj.TextGetCategory("Latest on the War in Iraq.");
        System.out.println(getStringFromDocument(doc));

        // Load a HTML document to analyze.
        String htmlDoc = getFileContents("data/example.html");

        // Categorize a HTML document by topic.
        doc = alchemyObj.HTMLGetCategory(htmlDoc, "http://www.test.com/");
        System.out.println(getStringFromDocument(doc));
        
        AlchemyAPI_CategoryParams categoryParams = new AlchemyAPI_CategoryParams();
        categoryParams.setOutputMode(AlchemyAPI_Params.OUTPUT_RDF);
        doc = alchemyObj.HTMLGetCategory(htmlDoc, "http://www.test.com/", categoryParams);
        System.out.println(getStringFromDocument(doc));
*/    }

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
