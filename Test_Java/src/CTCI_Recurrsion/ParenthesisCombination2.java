package CTCI_Recurrsion;

import java.util.*;
public class ParenthesisCombination2 {
	public static void main(String args[]){
		int num_paren = 2;
		ArrayList<String> list = new ArrayList<String>();
		ParenthesisCombination2 pc2 = new ParenthesisCombination2();
		list = pc2.getParenthesis(num_paren);
		for(String s :list){
			System.out.println(s);
		}
		
		
	}
	
	public ArrayList<String> getParenthesis(int count){
		ArrayList<String>  list = new ArrayList<String>();
		char str[] = new char[count * 2];
		addParen(list,str,count,count,0);
		return list;
	}
	
	public void addParen(ArrayList<String> list, char[] str, int leftparan, int rightparan , int count){
		if(leftparan <0 || rightparan<leftparan){
			return;
		}
		if(leftparan == 0 && rightparan == 0){
			String s = String.copyValueOf(str);
			list.add(s);
			
		}
		else{
			if(leftparan > 0){
				str[count] = '(';
				addParen(list,str,leftparan-1,rightparan,count+1);
			}
			if(rightparan > 0){
				str[count] = ')';
				addParen(list,str,leftparan,rightparan-1,count +1);
			}
		}
	}
}
