package Basics;
import java.io.*;

import org.omg.CORBA.ExceptionList;
class TestSerialization {
	public static void main(String args[]) {
		Ts3 tester = new Ts3(23,45);
		FileOutputStream fs;
		ObjectOutputStream os = null ;
		try{
		fs = new FileOutputStream("Serialisation.txt");
		os = new ObjectOutputStream(fs);
		os.writeObject(tester);
		os .close();
		}
		catch(FileNotFoundException fe){
			
		}
		catch(IOException ie){
			
		}
		finally{
//		fs.close();
//		os.close();
		}
		try{
		FileInputStream fis = new FileInputStream("Serialisation.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object one = ois.readObject();
		ois.close();
		Ts3 new_ts = (Ts3)one;
		//System.out.println(new_ts.s1);
		System.out.println(new_ts.s2);
		System.out.println(new_ts.s3);
		}
		catch(FileNotFoundException e){
			System.out.println("Error");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
/*
class Ts1 implements Serializable
{
int s1;
	public Ts1(){
		s1 = 69;
		
	}
	public Ts1(int s){
		s1= s;
		System.out.println("First Class");
	}

}
*/

class Ts2   {
int s2;

public Ts2(){
	System.out.println("Second time Ts2");
//	s1= 10;
	s2 = 100;
}
public Ts2(int s2){
	System.out.println("First");
//	s1= 10;
	s2 = s2;
}

/*
public Ts2(int s1, int s2){
	super(s1);
	System.out.println("Second class");
	s2 = s2;
}
*/
}

class Ts3 extends Ts2 implements Serializable {
int s3;
public Ts3( int s2,int s3){
//public Ts3(int s1, int s2,int s3){
	super(s2);
	System.out.println("Third Class");
	s3 = s3 ;
}
}
