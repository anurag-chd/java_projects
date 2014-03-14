package AmazonInterview;

public class LIS {
	public static void main(String args[]){
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int result = findLIS(arr,arr.length);
		System.out.println(result);
	}
	
	public static int findLIS(int arr[],int n){
		int lis[] = new int[n];
		for(int i = 0;i<n;i++){
			lis[i] = 1;
		}
		for(int i = 1; i<n ; i++){
			for(int j = 0; j < i; j++ ){
				if(arr[i]>arr[j]){
					lis[i] = Math.max(lis[i], 1+lis[j]);
				}
			}
		}
		int max = 0;
		for(int i = 0;i<n;i++){
			if(max < lis[i]){
				max = lis[i];
			}
		}
		return max;
	}
}
