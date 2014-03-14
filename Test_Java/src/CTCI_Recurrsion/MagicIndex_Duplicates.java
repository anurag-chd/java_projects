package CTCI_Recurrsion;

public class MagicIndex_Duplicates {
	public static void main(String args[]){
		int arr[] = {-40,0,2,2,2,3,5,7,9,12,13};
		MagicIndex_Duplicates mid = new MagicIndex_Duplicates();
		int index = mid.getIndex(arr, 0 , arr.length-1);
		System.out.println("The magic index is : "+ index);
	}
	
	public int getIndex(int arr[], int start , int end){
		if(start>end){
			return -1;
		}
		else{
			int mid = (start + end)/2;
			if(arr[mid] == mid){
				return mid;
			}
			int left_index = Math.min(arr[mid],mid-1);
			int left = getIndex(arr,start,left_index);
			if(left>=0){
				return left;
			}
			/*int left = getIndex(arr, start, mid-1);
			if(left>=0){
				return left;
			}*/
			int right_index = Math.max(arr[mid],mid+1);
			int right = getIndex(arr,right_index,end);
			return right;
			/*int right = getIndex(arr,mid+1,end);
			return right;
			*/
		}
	}

}
