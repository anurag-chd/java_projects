package AmazonInterview;

public class Shift_zeros {
	public static void main(String args[]){
		int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
		shiftArr(arr);
		shiftArr1(arr);
		
	}
	public static void shiftArr(int arr[]){
		int len = arr.length;
		int i;
		int count =0;
		for(i =0; i< len;i++){
			if(count== len){
				break;
			}
			for(int j =count;j<len;j++){
				if(arr[j]!= 0){
					arr[i]= arr[j];
					//System.out.println(arr[i]+""+i);
					count++;
					break;
				}
				else{
					count++;
				}
					
			}
		}
		System.out.println(i);
		
		while(i<len){
			arr[i] = 0;
			i++;
		}
		for(int j =0; j<len;j++)
			System.out.print(arr[j]+",");
	}
	
	public static void shiftArr1(int arr[]){
		/*int count =0;
		for(int i =0; i<arr.length;i++ ){
			if(arr[i] == 0){
				count++;
			}
			
		}*/
		int j =0;
		for(int i =0; i< arr.length;i++){
			if(arr[i]!=0){
				arr[j] = arr[i];
				j++;
			}
		}
		while(j<arr.length){
			arr[j]=0;
			j++;
		}
		System.out.println(	);
		for(int k =0; k<arr.length;k++)
			System.out.print(arr[k]+",");
		
	}
	
}
