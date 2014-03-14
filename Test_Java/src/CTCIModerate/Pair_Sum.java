package CTCIModerate;
import java.util.*;
public class Pair_Sum {

	public static void main(String args[]){
		int arr[] ={2,4,6,10,14,12};
		int sum = 16;
		HashMap<Integer,Integer> map = getPairs(arr,sum);
		System.out.println(map);
	}
	
	public static HashMap<Integer,Integer> getPairs(int arr[],int sum){
		Set<Integer> list = new HashSet<Integer>();
		//Collections.addAll(list, arr);
		for(int i : arr){
			list.add(i);
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0 ;i < arr.length;i++){
			if(list.contains(sum-arr[i])){
				map.put(arr[i],sum-arr[i]);
				list.remove(arr[i]);
			}
		}
		
		return map;
	}
	
}
