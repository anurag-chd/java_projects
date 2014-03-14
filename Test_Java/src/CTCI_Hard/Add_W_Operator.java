package CTCI_Hard;

public class Add_W_Operator {
	public static void main(String args[]){
		int a = 4;
		int b = 26;
		int result = sum(a,b);
		System.out.println(result);
	}
	
	public static int sum(int a, int b){
		if(b == 0){
			return a;
		}
		int sum = a^b;
		int carry = (a & b) << 0x1;
		return sum(sum,carry);
			 
	}

}
