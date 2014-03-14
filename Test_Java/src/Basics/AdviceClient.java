package Basics;
import java.io.*;
import java.net.*;

public class AdviceClient {
	public void go(){	
	
		try{
			
			Socket s = new Socket("127.0.0.1",4242);
			InputStreamReader isr = new InputStreamReader(s.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			String message;
			while((message=br.readLine())!=null){
				System.out.println(message);
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String srgs[]){
		AdviceClient adclient = new AdviceClient();
		adclient.go();
	}
}
