package Basics;
import java.io.*;
import java.net.*;

public class AdviceServer {

	String str = "Hello Anurag";
	
	public void go(){
		try{
			ServerSocket serversoc = new ServerSocket(4242);
			while(true){
				Socket soc = serversoc.accept();
				PrintWriter writer = new PrintWriter(soc.getOutputStream());
				writer.write(str);
				writer.close();
			}
		}
		catch(Exception e){
			
		}
	}
	
	public static void main(String args[]){
		AdviceServer adserver = new AdviceServer();
		adserver.go();
	}
}
