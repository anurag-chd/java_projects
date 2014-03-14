package CTCI;

public class UniqueChar {

	public static void main(String args[]){
		UniqueChar uc = new UniqueChar();
		String str = "abcdgyatre";
		if(uc.go(str)){
			System.out.println("Unique");
		}
		else{
			System.out.println("Non Unique");
		}
	}
	
	public boolean go(String str){
		boolean[] char_set = new boolean[256];
		
		for(int i = 0; i<str.length();i++){
			int temp = str.charAt(i);
			if(char_set[temp])
				return false;
			else{
				char_set[temp] = true;
			}
		
		
		}
		return true;
		
	}
}
