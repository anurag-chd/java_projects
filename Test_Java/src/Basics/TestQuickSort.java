package Basics;

public class TestQuickSort {
	public static void main(String args[]){
		int arr[] = {20,30,5,6,6};
		sort(arr,0,arr.length-1);
		for(int i : arr){
			System.out.print(i+",");
		}
	}
	
	public static void sort(int arr[],int start, int end){
		if(start >= end){
			return;
		}
		else{
			int pivot_index = getPartition(arr,start,end);
			//sort(arr,start,pivot_index);
			sort(arr,start,pivot_index);
			sort(arr,pivot_index+1,end);
		}
	}
	public static int getPartition(int arr[],int start, int end){
		int left=start,right=end;
		int pivot = arr[start];
		while(left< right){			
			while(arr[left]<=pivot){
				start++;
			}
			while(arr[right]>pivot){
				end--;
			}
			if(right>=left){
				swap(arr,left,right);	
			}
			
		}
		return right;
	}
	
	public static void swap(int arr[], int start,int  end){
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
	}

}
