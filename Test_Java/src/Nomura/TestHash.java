package Nomura;

import java.util.*;
public class TestHash {
	public static void main(String args[]){
		Hashtable<Integer,String> tab = new Hashtable<Integer,String>();
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		tab.put(1,"Anurag");
		map.put(1,"Anurag");
		tab.put(1, "Mrinal");
		map.put(1, "Mrinal");
		if(tab.contains("Anurag")){
			System.out.println("exist");
		}
		else{
			System.out.println("Overwrites");
		}
	//	map.	
		String str = new String("Anurag");
		String str1 = new String("Anurag1");
		str.replace('A','m' );
		System.out.println(str);
		System.out.println(tab.get(1));
		System.out.println(map.get(1));
	}

}
