package CTCIModerate;

public class LargestSumSequence {
	public static void main(String args[]){
		int arr [] ={2, -8, 3, -5, 4, 7};
		int result = find(arr);
		System.out.println(result);
	}
	
	public static int find(int arr[]){
		int sum =0, max_sum =0;
		for(int i =0; i<arr.length; i++){
			sum = sum + arr[i];
			if(sum > max_sum){
				max_sum = sum;
			}
			if(sum < 0){
				sum = 0;
			}
			
		}
		return max_sum;
	}

}
