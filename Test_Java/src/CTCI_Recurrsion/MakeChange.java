package CTCI_Recurrsion;
import java.util.*;
public class MakeChange {
	public static void main(String args[]){
		//int sum = 7;
		int sum = 100;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		//Collections.addAll(arr, 2,3,6,7);
		Collections.addAll(arr, 1,5,10,25);
		int new_arr[][] = new int[arr.get(arr.size()-1)+1][sum +1];
		for(int i =0;i<=arr.get(arr.size()-1);i++){
			for(int j =0;j<=sum;j++){
				if(j==0){
					new_arr[i][j] = 1;
				}
				else if(i ==0){
					new_arr[i][j] = 0;
				}
				else if(!arr.contains(i)){
					new_arr[i][j] = new_arr[i-1][j];
				}
				/*else if(i == 0 && j>0){
					new_arr[i][j] = 0;
				}*/
				else if(arr.contains(i) && i > j){
					new_arr[i][j] = new_arr[i-1][j];
				}
				else if(arr.contains(i) && i <= j){
					new_arr[i][j] = new_arr[i-1][j] + new_arr[i][j-i];
				}
			}
		}
		
		System.out.println("The number of schems will be " + new_arr[arr.get(arr.size()-1)][sum]);
		
	}

}
