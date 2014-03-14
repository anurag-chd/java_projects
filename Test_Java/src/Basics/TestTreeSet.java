package Basics;
import java.util.*;
public class TestTreeSet {

	public static void main(String args[]){
		new TestTreeSet().go();
	}
	void go(){
		Book b1 = new Book("B4");
		Book b2 = new Book("B5");
		Book b3 = new Book("B1");
		TreeSet<Book> myBookSet = new TreeSet<Book>();
		myBookSet.add(b1);
		myBookSet.add(b2);
		myBookSet.add(b3);
		System.out.println(myBookSet);
		
		
	}
}

class Book implements Comparable<Book>{
	String t;
	public Book(String s){
		t = s;
	}
	public int compareTo(Book b){
		return this.t.compareTo(b.t); 
	}
	public String toString(){
		return this.t;
	}
}