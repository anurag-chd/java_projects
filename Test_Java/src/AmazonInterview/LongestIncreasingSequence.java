package AmazonInterview;

public class LongestIncreasingSequence {
	public static void main(String args[]){
		int arr[] = {1,2,3,4,10,20,21,22,23,24,25};
		printSequence(arr);
	}
	
	public static void printSequence(int arr[]){
		int len = arr.length;
		int lis[] = new int[len];
		for(int i =0 ; i<len;i++){
			lis[i] = 1;
		}
		int max=0,max_index=0;
		for(int i =1 ;i<len;i++){
			if(arr[i] == arr[i-1] +1)
				lis[i] = lis[i-1] +1;
				if(max < lis[i]){
					max = lis[i];
					max_index= i;
				}
		}
		for(int i = max_index ; i>(max_index-max); i--){
			System.out.print(arr[i]+",");
		}
		System.out.println("Max length :" + max );
		
	}
}
