package AmazonInterview;

public class MaxProduct_array {
	public static void main(String args[]){
		int arr [] = {2,  3, -5, 4, 7,-6};
		int result = getResult(arr);
		System.out.println(result);
	}
	
	public static int getResult(int arr[]){
		int min1=0,min2=0, max1=0 , max2 =0;
		for(int i =0; i<arr.length;i++){
			if(max1<arr[i] ){
				max2 = max1;
				max1= arr[i];
				
			}
			if(max1> arr[i] && max2 < arr[i]){
				max2 = arr[i];
			}
			if(min1>arr[i]){
				min2 = min1;
				min1 = arr[i];
			}
			if(min1<arr[i] && min2 > arr[i]){
				min2 = arr[i];
			}
			
		}
		int max_product = max1 * max2;
		int min_product = min1 * min2;
		return Math.max(min_product,max_product);
		
	}

}
