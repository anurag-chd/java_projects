package AmazonInterview;

public class Three_Max_Product {
	public static void main(String args[]){
		int arr[] = {6, 7, 8, 1, 2, 3, 9, 10};
		findMaxProd(arr);
	}
	
	public static void findMaxProd(int arr[]){
		int max1= 0, max2 = 0, max3=0;
		for(int i =0;i< arr.length;i++){
			if(max1<arr[i]){
				max3 = max2;
				max2 = max1;
				max1 = arr[i];
			}
			else if(max1>arr[i] && max2< arr[i]){
				max3 = max2;
				max2 = arr[i];
			}
			else if(max2>arr[i] && max3 < arr[i]){
				max3 = arr[i];
			}
			
		}
		
		System.out.print(max3+","+max2+","+max1);
		
	}
}
