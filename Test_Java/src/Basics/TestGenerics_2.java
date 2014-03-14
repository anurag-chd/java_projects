package Basics;
import java.util.*;
public class TestGenerics_2 {

	public  static  void main(String args[]){
		ArrayList<C> alist = new ArrayList<C>();
		C c1 = new C();
		C c2 = new C();
		alist.add(c1);
		alist.add(c2);
		
		createList(alist);
		
	//	myList.add(c1);
	//	myList.add(c2);
	
	}
	static <T extends B> void createList(ArrayList<T> list){
		for(B a : list){
			a.run();
			a.stop();
		}
	}
		
	
}

 interface A {
	public void go();
}

abstract class B {
	abstract void run();
	public void stop(){
		System.out.println("Stop");
	}
}

class C extends B implements A{
	public void go(){
		System.out.println("Go");
	}
	public void run(){
		System.out.println("Run");
	}
}