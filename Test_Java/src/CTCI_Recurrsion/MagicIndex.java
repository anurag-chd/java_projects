package CTCI_Recurrsion;

public class MagicIndex {
	public static void main(String args[]){
		int arr[] = {-40,-20,-1,1,2,3,5,7,9,12,13};
		MagicIndex mi = new MagicIndex();
		int index = mi.getIndex(arr,0,arr.length-1);
		System.out.println("Magic Index is "+index);
	}
	
	public int getIndex(int []arr, int start , int end){
		if(start>end){
			return -1;
		}
		else{
			int mid = (start+end)/2;
			if(arr[mid] == mid){
				return mid;
			}
			else if(arr[mid] < mid){
				return getIndex(arr,mid+1,end);
			}
			else{
				return getIndex(arr,start,mid);
			}
			
			
		}
	}

}
