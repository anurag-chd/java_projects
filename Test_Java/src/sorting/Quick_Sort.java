package sorting;
import java.util.*;

public class Quick_Sort {
	
	public static void main(String args []){
		//Integer arr[] = {20,30,10,5,5,40,70,6,34,60};
		Integer arr[] = {20,30,5,6};
		Quick_Sort qsort = new Quick_Sort();
		qsort.sort(arr,0,(arr.length)-1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list,arr);
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.print(it.next() + " ");
		}
		
	}
	
	public void sort(Integer[] arr,int lower,int higher){
		if(lower>=higher){
			return ;
		}
		int pivot_index = getPartition(arr,lower,higher);
		sort(arr,lower,pivot_index);
		sort(arr,pivot_index+1,higher);
			
		}
	public int getPartition(Integer []arr, int lower, int higher){
		int pivot = arr[lower];
		while(lower< higher){
			while(arr[lower]<pivot){
				lower++;
			}
			while(arr[higher]>pivot){
				higher--;
			}
			swap(arr,lower,higher);
			
		}
		return lower;
	}
	
	public void swap(Integer arr[],int lower, int higher){
		int temp = arr[lower];
		arr[lower] = arr[higher];
		arr[higher] = temp;
	}
		
		
		
	}


