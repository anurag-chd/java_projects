package AmazonInterview;

public class Fibonacci_Revise {
	public static void main(String args[]){
		int fib = 1000;
		int num = 4;
		//getFib(fib);
		getSequence(fib,num);
	}
	
	public static void getSequence(int fib,int num){
		int len;
		if(num > 3){
			len = num +1;
		}
		else{
			len = 3;
		}
		int arr[] = new int[len];
		arr[0] = 0;
		arr[1] = 1;
		int i =0, count =0;
		while(fib>arr[i]){
			
			if(count == 0){
				if(i>1){
				i++;
				arr[i] = arr[i-1] +arr[i-2];
				count = 1;
				}
				else{
					i++;
				}
			}
			if( count == 1){
				if(i == len-1){
					
					i = 0;
					arr[i] = arr[len-1] + arr[len-2];
				}
				else if(i == 0){
					i++;
					arr[i] = arr[0] + arr[len-1]; 
				}
				else{
					i++;
					arr[i] = arr[i-1] +arr[i-2];
				}
			}
		}
		System.out.println(arr[i-1]);
		for(int j = 0; j<=num;j++){
			System.out.print(arr[j]+",");
		}
		
	}
	
	public static void getFib(int fib){
		int arr[] = new int[fib];
		arr[0] = 0;
		arr[1] = 1;
		//for(int i = 2;i<fib )
		int i = 0;
		while(fib>arr[i]){
			i++;
			if(i>1){
				arr[i] = arr[i-1] +arr[i-2];
			}
		}
		System.out.println(arr[i-1]);
		
	}

}
