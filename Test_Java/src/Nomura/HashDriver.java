package Nomura;
import java.util.*;
public class HashDriver {
	public static void main(String args[]){
		HashTableImpl table = new HashTableImpl();
		
		Integer i = new Integer(10);
		int j = Integer.parseInt(i.toString());
		System.out.println(j);
		table.add(20,"Anurag");
		table.add(20,"Mrinal");
		table.add(30,"Mrinal");
		table.add(40,"Raghav");
		System.out.println(table.get(20));
		System.out.println(table.get(30));
		System.out.println(table.get(40));
		table.remove(20);
		System.out.println(table.get(20));
		ArrayList<Object>[] employeeLevels = new ArrayList[5];
	}
}
