package CTCIModerate;

public class NumZeros_Factorial {
	public static void main(String args[]){
		int num = 16;
		int result = findZero(num);
		System.out.println(result);
	}
	
	public static int findZero(int num){
		int count =0; 
		for(int i = 5; num/i >0 ; i = i*5 ){
			count = count + num/i;
		}
		long mul = 1;
		for(int i = num ;i>0;i--){
			mul = mul * i;
		}
		System.out.println(mul);
		return count;
	}
}
