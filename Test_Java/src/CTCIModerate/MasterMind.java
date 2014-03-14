package CTCIModerate;

import java.util.*;

public class MasterMind {
	public static void main(String args[]){
		String str1 = "RGGB";
		String str2 = "YRGB";
		getResult(str1, str2);
	
	
	}
	
	public static void getResult(String str1, String str2){
		char arr1[] = str1.toCharArray();
		char arr2[] = str2.toCharArray();
		HashMap<Character,ArrayList<Integer>> list = new HashMap<Character,ArrayList<Integer>>();
		for(int i = 0; i<arr1.length ;i++){
			if(!list.containsKey(arr1[i])){
				ArrayList<Integer> list_num = new ArrayList<Integer>();
				list_num.add(i);
				list.put(arr1[i], list_num);
			}
			else{
				ArrayList<Integer> temp = list.get(arr1[i]);
				temp.add(i);
			}
		}
		int psudo_hit =0, hit = 0;
		for(int i = 0; i < arr2.length;i++){
			if(list.containsKey(arr2[i])){
				ArrayList<Integer> temp = list.get(arr2[i]);
				if(temp.contains(i)){
					hit++;
				}
				else{
					psudo_hit++;
				}
			}
		}
		System.out.println("No. of hits :" + hit +", No of pseudo hits " + psudo_hit);
 	}
}
