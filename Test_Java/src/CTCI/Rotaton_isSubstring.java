package CTCI;

public class Rotaton_isSubstring {
	public static void main(String args[]){
		String str1 = "anurag";
		String str2 = "ganura";
		Rotaton_isSubstring ris = new Rotaton_isSubstring();
		ris.isRotation(str1, str2);
		
	}
	
	public void isRotation(String str1,String str2){
		if (str1.length() != str2.length()){
			System.out.println("Not rotation");
		}
		else{
			str1 = str1 + str1;
			System.out.println(str1);
			if(isSubstring(str1,str2)){
				System.out.println("Rotated String");
			}
			else{
				System.out.println("Not rotation");
			}
		}
	}
	
	public boolean isSubstring(String str1, String str2){
		for(int i = 0 ;i< str2.length(); i++){
			System.out.println(str1.substring(i,str2.length()+i));
			if(str2.equals(str1.substring(i,str2.length()+i))){
				return true;
			}
		}
		return false;
	}
	
}
