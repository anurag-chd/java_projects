package Basics;
import java.io.*;

import org.omg.CORBA.ExceptionList;
class TestSerialization2 {
	public static void main(String args[]){
		Ts_3 tester = new Ts_3(21,23,45);
		FileOutputStream fs;
		ObjectOutputStream os;
		try{
		fs = new FileOutputStream("Serialisation_2.txt");
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
	//	os.close();
		}
		try{
		FileInputStream fis = new FileInputStream("Serialisation_2.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object one = ois.readObject();
		ois.close();
		Ts_3 new_ts = (Ts_3)one;
		System.out.println(new_ts.s1);
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

class Ts_1 implements Serializable{
	
int s1;
	public Ts_1(){
		s1 = 69;
		System.out.println("Second Time Ts1");
		
	}
	public Ts_1(int s){
		s1= s;
		System.out.println("First Class");
	}

}


class Ts_2 extends Ts_1  {
int s2;

public Ts_2(){
	System.out.println("Second time Ts2");
	s1= 10;
	s2 = 100;
}

public Ts_2(int s1, int s2){
	super(s1);
	System.out.println("Second class");
	s2 = s2;
}

}

class Ts_3 extends Ts_2 implements Serializable {
int s3;

public Ts_3(int s1, int s2,int s3){
	super(s1,s2);
	System.out.println("Third Class");
	s3 = s3 ;
}
}
