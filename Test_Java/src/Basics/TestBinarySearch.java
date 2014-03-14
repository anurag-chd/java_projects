package Basics;

public class TestBinarySearch {
	public static void main(String args[]){
		int arr[] = {1,10,23,44,56,67,89};
		int num = 10;
		if(search(arr,0,arr.length -1,num)){
			System.out.println("Number found");
		}
		else{
			System.out.println("Number not present");
		}
	}
	public static boolean search(int arr[], int start, int end, int num){
		if(start>end){
			return false;
		}
		else{
			int mid = (start + end)/2;
			if(arr[mid] == num){
				return true;
			}
			else if(arr[mid]>num){
			return 	search(arr,start,mid-1,num);
			}
			else{
			return 	search(arr,mid+1,end,num);
			}
			
		}
		
	}

}
