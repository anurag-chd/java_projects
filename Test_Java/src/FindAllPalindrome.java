import java.util.*;

public class FindAllPalindrome {

	public static void main(String args[]){
		String str = "abcddcbaABCDEDCBA";
		FindAllPalindrome fap = new FindAllPalindrome();
		ArrayList<String> pals =fap.find(str);
		Iterator<String> it = pals.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public ArrayList<String> find(String str){
		ArrayList<String> pals = new ArrayList<String>();
		
		if(str.length() == 0){
			System.out.println("Empty String");
			return null;
		}
		if(str.length() <=2){
			System.out.println("String is small");
			return null;
		}
		else{
			for(int i = 1; i<str.length(); i++){
				for(int j= i-1, k=i+1;j>=0 && k < str.length();j--,k++){
					if(str.charAt(j) == (str.charAt(k))){
						pals.add(str.subSequence(j,k+1).toString());
					}
					else{
						break;
					}
				}
				
				for(int j =i , k=i+1;j >=0 && k <str.length(); j--, k++ ){
					if(str.charAt(j) == (str.charAt(k))){
						pals.add(str.subSequence(j,k+1).toString());
					}
					else{
						break;
					}
				}
			}
		}
		
				return pals;
	}
}
