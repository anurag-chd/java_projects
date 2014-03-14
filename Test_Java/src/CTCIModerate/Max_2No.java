package CTCIModerate;

public class Max_2No {
	public static void main(String args[]){
		int a = 10, b = 25;
		int c = a -b;
		int k = (c >> 31) & 0x1;
		int d = a - (k*c);
		System.out.println(d);
	}

}
