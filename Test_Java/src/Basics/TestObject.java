package Basics;
import java.util.ArrayList;
public class TestObject {
	int a;
public static void main(String args[]){
//	System.out.println(a);
	TestBox t = new TestBox();
	t.go();
	Foo f = new Foo();
	f.go(20);
	ArrayList<Cat> myDogList = new ArrayList<Cat>();
	Cat d = new Cat();
	Cat.drink();
	//d.length;
	myDogList.add(d);
	Animal d2 = myDogList.get(0);
	d2.eat();
	System.out.println(d2.getClass());
	
	
}
}
class Animal{
	 private int length;
	 public Animal(int i){
		 length = i;
	 }
	
	 public void eat(){}
	//abstract void bark();
}

class Cat extends Animal{
	final int shape = 10;
	public Cat(){
		
		this(23,24);
	}
	
	
	public Cat(int i, int j){
		//shape = i;
		super(i);
		//shape = i;
	}
	
	public static void drink(){
		int i;
		System.out.println("Milk");
		//eat();
	}
	public void eat(){
		
	}
	public void bark(){
		System.out.println("whoof");
	}
}

class Foo{
	int x1 =12;
	public void go(final int x){
		this.x1 = x;
		System.out.println(x);
		System.out.println(x1);
	}
}
class TestBox{
	Integer i ;
	int j = 10;
	public void go(){
		j= i.intValue();
		System.out.println(i);
		System.out.println(j);
	}
}