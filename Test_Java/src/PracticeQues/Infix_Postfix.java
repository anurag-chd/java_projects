package PracticeQues;

import java.util.ArrayList;
import java.util.Collections;

public class Infix_Postfix {
	static ArrayList<Character> opr_list = new ArrayList<Character>();
	static My_stack<Character> stack = new My_stack<Character>(); 
	public static void main(String args[]){
		String str = "(3 + 4) * 2 ";
		
		char[] tokens = str.toCharArray();
		Collections.addAll(opr_list, '+','-','*','/');
		
		for(int i = 0 ; i< tokens.length ;i++){
			if(Character.isDigit(tokens[i])){
				System.out.print(tokens[i]);
			}
			if(tokens[i] == '(')
				stack.push(tokens[i]);
			if(tokens[i] == ')'){
				char temp;
				while(stack.top > -1 && (temp= stack.pop()) != '('){
					
					System.out.print(temp);
				}
			}
			if(opr_list.contains(tokens[i])){
				if(stack.top == -1)
					stack.push(tokens[i]);
				else{
					char temp;
					while(stack.top>-1 && getPriority(temp = stack.pop()) < getPriority(tokens[i]) ){
						
						
							System.out.print(temp);
						
						
					}
					stack.push(tokens[i]);
					
					
				}
			}
				
		}
		
		while(stack.top!=-1){
			System.out.print(stack.pop());
		}
		
	}
	
	public static int getPriority(char c){
		if(c =='(' || c== ')')
			return 8;
		if(c == '^'){
			return 5;
		}
		if(c == '/')
			return 4;
		if(c == '*')
			return 3;
		if(c == '-')
			return 2;
		if(c == '+')
			return 1;
		else{
			return 0;
		}
		
	}

}
