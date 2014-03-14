package sorting;

public class HeapSort {
	//static int arr[] = {20,30,10,5};
	public static void main(String args[]){
		//int arr[] = {20,30,10,5,9,40,70,6,34,60};
		int arr[] = {20,30,10,5,9,40,70};
		HeapSort hsort = new HeapSort();
		System.out.println(arr[0]);
		/*int new_arr[]=*/hsort.sort(arr);
		
		System.out.println(arr[0]);
		for(int i =0 ;i <arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	public /*int []*/void sort(int arr[]){
		
		int count = arr.length;
		/*arr =*/ heapify(arr, count);
		int end = count-1;
		while(end>0){
			/*arr =*/ swap(arr,0,end);
			end = end -1;
			/*arr =*/ shiftdown(arr,0,end);
			
		}
		//return arr;
	}
	
	public /*int []*/void heapify(int arr[], int count)
	{
		int start = (count -2)/2;
		while(start >= 0){
			shiftdown(arr,start,count-1);
			start = start -1;
					
		}
		//return arr;
	}
	
	public /*int []*/void shiftdown(int arr[], int start, int end){
		int root = start;
		while((root *2)+1 <=end ){
			int child = (root*2)+1;
			int swap = root;
			
			if(arr[swap] > arr[child]){
				swap = child;
			}
			if(child+1<=end && arr[swap] > arr[child+1]){
				swap = child+1;
			}
			if(swap != root){
			/*	arr =*/ swap(arr,root,swap);
			root = swap;
			}
			else
				//return arr;
				return ;
		}
		//return arr;
		 
	}
	
	public /*int[]*/ void swap(int arr[], int a , int b){
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
		//return arr;
	}
	
	
}
