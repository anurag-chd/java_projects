package CTCI;

public class StringRev {

	public static void main(String args[]){
		StringRev sr = new  StringRev();
		String str = "anurag";
		sr.go(str);
	}
	
	public void go(String str){
		int i = 0;
		int j = str.length() - 1;
		char c[] = str.toCharArray();
		while(i<=j){
			char temp;
			temp = c[i];
			c[i] = c[j];
			c[j] = temp;
			i++;
			j--;
		}
		for(int k =0 ;k<c.length;k++){
			System.out.print(c[k]);
		}
		
		
	}
}
