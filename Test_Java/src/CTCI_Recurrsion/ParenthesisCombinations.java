package CTCI_Recurrsion;
import java.util.*;

public class ParenthesisCombinations {
	public static void main(String args[]){
		int num_paren = 3;
		Set<String> paren_list = new HashSet<String>();
		ParenthesisCombinations pc = new ParenthesisCombinations();
		paren_list = pc.getParen(num_paren);
		for(String s :paren_list){
			System.out.println(s);
		}
	}
	
	
	public Set<String> getParen(int remaining){
		Set<String> list = new HashSet<String>();
		if(remaining == 0){
			list.add("");
			return list;
		}
		else{
			Set<String> prev_list = getParen(remaining -1);
			for(String p:prev_list){
				for(int i = 0; i<p.length();i++){
					if(p.charAt(i) == '('){
						String str1 =insertParen(p,i);
						list.add(str1);
					}
				}
				if(!list.contains("()"+p)){
					list.add("()"+p);
				}
			}
		return list;	
		}
		
	}
	
	public String insertParen(String str, int index){
		String left = str.substring(0,index+1);
		String right = str.substring(index+1);
		return left + "()" + right;
	}

}
