package Basics;
import java.io.*;
import java.util.*;

public class TestPairClass {
	public static void main(String args[]){
		Pair<Month, Integer> p = new Pair<Month, Integer>(Month.Nov, 29);
		System.out.println(p);
		TestPairClass tpc = new TestPairClass();
		String [] a = new String[]{"Jab","Mila","Tu"};
		Set<String> str = new HashSet<String>();
		Collections.addAll(str,a);
		tpc.print(a);
		Iterator it = str.iterator();
		for(;it.hasNext();){
			System.out.println(it.next());
		}
		Iterator it2 = str.iterator();
		for(;it2.hasNext();){
			it2.next();
			it2.remove();
		}
		for(;it.hasNext();){
			System.out.println(it.next());
		}
		int z = 5;
 		Integer [] b =new Integer[5];
 		//b = {1,2,3,4};
 		b[4] = 5;
		Character [] c = new Character[]{'a','b','c'};
 		tpc.print(b);
 		tpc.print(c);
	}
	
	public <S> void print(S[] a){
		for(S i: a){
			System.out.printf("%s ",i);
		}
		System.out.println(" ");
	}

}

enum Month {Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec};

class Pair<S,T>{
	 private S first;
	 private T second;
	
	public Pair(S first, T second){
		this.first = first;
		this.second = second;
	}
	
	public void setFirst(S first){
		this.first = first;
	}
	public S getFirst(){
		return this.first;
	}
	
	public void setSecond(T second){
		this.second = second;
	}
	public T getSecond(){
		return this.second;
	}
	
	public String toString(){
		String str = "The month is " +this.getFirst()+ " and the date is " +this.getSecond();
		return str;
	}
}

