package CTCI;

public class Anagram {

	public static void main(String args[]){
		String str1 = "anurag";
		String str2 = "rnugaa";
		Anagram ana = new Anagram();
		if(ana.find(str1, str2)){
			System.out.println("Anagram");
		}
		else{
			System.out.println("Not Anagram");
		}
	}
	
	public boolean find(String str1, String str2){
		int [] char_set1 = new int[str1.length()];
		int [] char_set2 = new int[str2.length()];
		for (int i = 0 ; i< str1.length() ;i++){
			char_set1[i] = str1.charAt(i);
		}
		for (int i = 0 ; i< str2.length() ;i++){
			char_set2[i] = str2.charAt(i);
		}
		int sum1=0;
		int sum2 = 0;
		int mul1 = 1;
		int mul2 = 1;
		for(int i = 0; i<str1.length();i++){
			sum1 = sum1 + char_set1[i];
			mul1 = mul1 * char_set1[i]; 
		}
		
		for(int i = 0; i<str2.length();i++){
			sum2 = sum2 + char_set2[i];
			mul2 = mul2 * char_set2[i]; 
		}
		
		if(sum1 == sum2 && mul1 == mul2){
			return true;
		}
		else{
			return false;
		}

	}
	
}
