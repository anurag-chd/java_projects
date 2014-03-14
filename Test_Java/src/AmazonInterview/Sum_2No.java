package AmazonInterview;
import sorting.*;

public class Sum_2No {
	public static void main(String args[]){
		Integer arr[] = {6,4,5,7,9,1,2};
		Quick_Sort tqs = new Quick_Sort();
		int num =9; 
		tqs.sort(arr, 0, arr.length-1);
		for(int i : arr)
		System.out.print(i+",");
		getNo(arr,num);
		
	}
	
	public static void getNo(Integer arr[], int num){
		int start = 0;
		int end = arr.length -1;
		while(start<end){
			if(arr[end] == num-arr[start]){
				System.out.println("{"+arr[start]+","+arr[end]+"}");
				start++;
				end--;
			}
			else{
				if(arr[end]< num -arr[start]){
					start++;
				}
				else{
					end--;
				}
			}
		}
	}
}
