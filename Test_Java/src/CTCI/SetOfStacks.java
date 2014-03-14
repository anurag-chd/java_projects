package CTCI;
import DataStructure.Stack;
import java.util.*;

public class SetOfStacks {
	static int max_items = 0;
	ArrayList<Stack<Integer>> stack_list = new ArrayList<Stack<Integer>>();
	
	public void push(int num){
		int stack_num;
		stack_num = max_items/5;
		//Stack s = stack_list.get(stack_num) 
		if(max_items%5 == 0){
			stack_list.add(stack_num,new Stack<Integer>());
			stack_list.get(stack_num).push(num);
			
		}
		else{
			stack_list.get(stack_num).push(num);
			
		}
		if(max_items!=0 && max_items%5 == 0){
			stack_list.get(stack_num).peek().setNext(stack_list.get(stack_num-1).peek());
		}
		max_items ++;
				
	}
	
	public int pop(){
		if(max_items == 0){
			System.out.println("the stack is empty");
			return -1;
		}
		else{
			int value;
			int stack_num = max_items/5;
			value = stack_list.get(stack_num).pop();
			return value;
		}
		
	}
	
	public int popAt(int index){
		/*if(stack_list.get(index).pop() == -1){
			System.out.println("The Stack" + index +" is empty") ;
			return -1;
		}*/
		int stack_num = index;
		int value;
		value = stack_list.get(stack_num).pop();
		if(((stack_num+1) *5)<max_items ){
			stack_list.get(stack_num+1).peek().setNext(stack_list.get(stack_num).peek());
		}
		max_items --;
		return value;
		
	}
	
	public static void main(String args[]){
		SetOfStacks sos = new SetOfStacks();
		
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		sos.push(5);
		sos.push(6);
		sos.push(7);
		sos.push(8);
		System.out.println(sos.pop());
		System.out.println(sos.stack_list.get(1).peek().getvalue());
		System.out.println(sos.pop());
		System.out.println(sos.popAt(0));
		//System.out.println(sos.pop());
		//System.out.println(sos.pop());
		System.out.println(sos.popAt(1));
		System.out.println(sos.popAt(1));
		//System.out.println(sos.popAt(1));
	}
	
	
	
}
