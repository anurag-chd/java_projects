package AmazonInterview;

public class Arr_Elem_n_k {
	public static void main(String args[]){
		int arr[] = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
		sort(arr,0,arr.length-1 );
		for(int i : arr){
			System.out.print(i+",");
		}
		printNum(arr,k);
		
	}
	
	public static void printNum(int arr[], int k){
		int num = arr.length/k;
		int count = 1;
		for(int i =1;i<arr.length;i++){
			if(arr[i]== arr[i-1]){
				count++ ;
			}
			if(arr[i]>arr[i-1]){
				count =1;
			}
			if(count ==num){
				System.out.println(arr[i]);
			}
		}
	}
	
	
	public static void sort(int arr[],int start, int end){
		if(start>end){
			return;
		}
		else{
			int left = start;
			int right = end;
			int pivot = arr[left];
			while(left<right){
				while(left<=end && arr[left]<=pivot  )
					left++;
				while(right >= start && arr[right]>pivot  )
					right--;
				if(left<=right){
					swap(arr,left,right);
				}
				
			}
			swap(arr,start,right);
			sort(arr,start,right-1);
			sort(arr,right+1,end);
		}
	}
	
	public static void swap(int arr[],int lower, int higher){
		int temp = arr[lower];
		arr[lower] = arr[higher];
		arr[higher] = temp;
	}

}
