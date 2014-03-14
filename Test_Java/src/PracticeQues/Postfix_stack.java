package PracticeQues;

public class Postfix_stack {

	public static void main(String args[]){
		String expression = "532+8*+";
		char[] exparr = expression.toCharArray();
		My_stack<Integer> stack = new My_stack<Integer>();
		for(int i = 0 ; i<exparr.length;i++){
			switch (exparr[i]){
				case '+':
					int temp1 = stack.pop();
					int temp2 = stack.pop();
					temp1 = temp1+temp2;
					stack.push(temp1);
					break;
				case '-':
					 temp1 = stack.pop();
					 temp2 = stack.pop();
					temp1 = temp2 - temp1;
					stack.push(temp1);
					break;
				case '*':
					temp1 = stack.pop();
					temp2 = stack.pop();
					temp1 = temp2 * temp1;
					stack.push(temp1);
					break;
				case '/':
					temp1 = stack.pop();
					temp2 = stack.pop();
					temp1 = temp2 / temp1;
					stack.push(temp1);
				default:
					StringBuilder str = new StringBuilder() ;
					str.append(exparr[i]);
					stack.push(Integer.parseInt(str.toString()));
			}
		}
		int result = stack.pop();
		System.out.println("The result of expression is : " +result);
	}
	
	
	
}

class  My_stack<E>{
	E arr[] = (E[])new Object[50];
	int top;
	
	public My_stack(){
		top = -1;
	}
	
	public void push(E data){
		if(top == arr.length-1){
			System.out.println("Stack is full");
			return ;
		}
		else{
			top++;
			arr[top] = data; 
		}
	}
	
	public E pop(){
		if(top == -1){
			System.out.println("Stack is empty");
			return null;
		}
		else{
			E data;
			data = arr[top];
			top--;
			return data;	
		}
	}
	
	
}