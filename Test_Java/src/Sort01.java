
public class Sort01 {

	public static void main(String args[]){
		int arr[] = {1, 2, 0, 0, 1, 1, 2};
		int arr_size= arr.length;
		Sort01 s = new Sort01();
		int new_arr[] = s.sort(arr, arr_size);
		s.printArr(new_arr);
		
	}
	
	public int [] sort(int arr[], int length){
		int low_index = 0;
		int high_index = length-1;
		int mid = 0;
		while(mid <= high_index){
			switch(arr[mid]){
			 	case 0:
		          arr= swap(arr,low_index++, mid++);
		           break;
		        case 1:
		           mid++;
		           break;
		        case 2:
		           arr = swap(arr,mid, high_index--);
		           break;
			}
			
		}
		return arr;
	}
	
	
	public int[] swap(int arr[], int a , int b){
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		return arr;
	}
	
	public void printArr(int arr[]){
		System.out.print("{");
		for (int i = 0; i<arr.length ;i++){
			System.out.print(arr[i]+",");
		}
		System.out.print("}");
	}
	
}
