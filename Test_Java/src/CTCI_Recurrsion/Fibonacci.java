package CTCI_Recurrsion;

public class Fibonacci {
	public static void main(String args[]){
		int number = 10;
		Fibonacci fib = new Fibonacci();
		int result = fib.get(number);
		System.out.println(result);
	}
	
	public int get(int number){
		if(number == 0){
			return 0;
		}
		if (number == 1){
			return 1;
		}
		else{
			return (get(number-1) + get(number -2));
		}
	}

}
