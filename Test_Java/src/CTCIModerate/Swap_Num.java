package CTCIModerate;

public class Swap_Num {
	public static void main(String args[]){
		int a = 4, b = 6;
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + ", " +b);
		
		a = (a ^ b);
		b = b ^ a;
		a = a ^ b;
		
		System.out.println(a + ", " +b);
	}
}
