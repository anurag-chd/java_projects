package sorting;

public class Mergesort {
	public static void main(String args[]){
		int arr[] = {20,30,10,5,5,40,70,6,34,60};
		Mergesort sort = new Mergesort();
		
		sort.msort(arr,0,arr.length-1);
		for(int i =0; i<arr.length ;i++ ){
			System.out.print(arr[i] + " " );
		}
	}
	
	public void msort(int []arr, int lower, int higher){
		/*if(lower>=higher){
			return;
		}*/
		//else{
		if(lower<higher){
			int middle = (lower + higher)/2;
			msort(arr,lower,middle);
			msort(arr,middle+1,higher);
			merge(arr,lower,middle,higher);
		}
	}
	
	public void merge(int[] arr, int lower, int middle, int higher){
		int temp [] = new int[arr.length];
		for(int i = 0 ; i <arr.length ; i++){
			temp[i] = arr[i];
		}
		int i = lower;
		int j = middle+1;
		int k = lower;
		
		while(i <= middle && j <=higher){
			if(temp[i]>=temp[j]){
				arr[k]=temp[j];
				j++;
			}
			else{
				arr[k] = temp[i];
				i++;
			}
			k++;
			
			}
			
			if(i>middle){
				while(j<=higher){
					arr[k]= temp[j];
					j++;
					k++;
				}
			}
			else{
				while(i<=middle){
					arr[k] = temp[i];
					i++;
					k++;
				}
			}
		}
	}


