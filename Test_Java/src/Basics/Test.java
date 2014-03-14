package Basics;

public class Test {
	void m1(){
		System.out.println("A");
		
	}
	public Test m3(){
		System.out.println("Polymorphism in A");
		return this;
	}
	public static void main(String args[]){
		Test a = new Test2();
		((Test2) a).m2();
		Test b = a.m3();
		b.m1();
	}
	
	
}

class Test2 extends Test{
	 void m1(){
		System.out.println("B");
	}
	 public Test2 m3(){
			System.out.println("Polymorphism in B");
			return this;
		}
	 
	 void m2(){
		 System.out.println("c");
	 }
}
