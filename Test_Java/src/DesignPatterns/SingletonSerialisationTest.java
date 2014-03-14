package DesignPatterns;
import binaryTree.*;
import java.io.*;

public class SingletonSerialisationTest {
	public static void main(String args[]){
		String str = "asdf";
		
		BinaryST btree = new BinaryST(12);
		try{
			File f = new File ("Singleton.txt");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			DemoSingleton single = DemoSingleton.getInstance();
			oos.writeObject(single);
			oos.close();
			single.seti(20);
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			DemoSingleton single2 = (DemoSingleton)ois.readObject();
			ois.close();
			System.out.println("Object 1 i=" + single.geti());
			System.out.println("Object 2 i=" + single2.geti());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}


class DemoSingleton implements Serializable{
	private volatile static DemoSingleton instance = null;
	
	private DemoSingleton(){
		
	}
	
	public static DemoSingleton getInstance(){
		if(instance == null){
			synchronized(DemoSingleton.class){
				if(instance == null){
					instance = new DemoSingleton();
				}
			}
			
		}
		return instance;
	}
	
	protected Object readResolve(){
		return instance;
	}
	
	private int i = 10;
	
	public int geti(){
		return i;
	}
	
	public void seti(int j){
		this.i = j;
	}
}
