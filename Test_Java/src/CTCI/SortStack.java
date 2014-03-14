package CTCI;

import DataStructure.Stack;

public class SortStack {
	public static void main(String args[]){
		Stack<Integer> s = new Stack<Integer>();
		s.push(7);
		s.push(5);
		s.push(8);
		s.push(10);
		s.push(15);
		SortStack ss = new SortStack();
		Stack<Integer> sort_stack = ss.sort(s);
		while(!sort_stack.isEmpty()){
			System.out.println(sort_stack.pop());
		}
		
	}
	
	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!r.isEmpty() && (int)r.peek().getvalue()>temp)
				s.push(r.pop());
			r.push(temp);
		}
		return r;
	}
	

}
