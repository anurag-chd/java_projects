package CTCI_Recurrsion;
import java.util.*;
public class Permutation_String {
	 ArrayList<String> perms = new ArrayList<String>();
	public static void main(String args[]){
		String str= "abc";
		ArrayList<String> result = new ArrayList<String>();
		Permutation_String ps = new Permutation_String();
		result = ps.getPerms(str);
		for(String s: result){
			System.out.println(s);
		}
		
	}
	
	public ArrayList<String> getPerms(String str){
		if(str == null){
			return null;
		}
		ArrayList<String> perms = new ArrayList<String>();
		if(str.length() == 0){
			perms.add("");
			return perms;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words =getPerms(remainder);
		for(String str1 : words){
			for(int j = 0 ;j<=str1.length();j++){
				String str2 = insertChar(str1,first,j);
				perms.add(str2);
			}
			
		}
		return perms;
				
	}
	
	public String insertChar(String str, char c, int i){
		String start = str.substring(0, i);
		String end = str.substring(i);
		return start + c + end; 
	}

}
