package Basics;

public class TestMultiplication_Recurrsion {
	
	public static void main(String args[]){
		int a = 5, b=7;
		int result = mul(20,15);
		System.out.println(result);
		
	}
	
	public static int mul(int a , int b){
		if(b == 1){
			return a;
		}
		int mid = b/2;
		if(!(mid%2 == 0)){
			return (mul(a,mid) + mul(a,mid) +a);
		}
		else{
			return (mul(a,mid) + mul(a,mid) );
		}
	}
	

}
