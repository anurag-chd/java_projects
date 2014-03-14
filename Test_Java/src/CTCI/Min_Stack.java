package CTCI;

public class Min_Stack {
	
	MinStackNode top;
	int min;
	public void push(int value){
		MinStackNode temp = new MinStackNode(value);
		if(top == null){
			temp.setNext(top);
			min = value;
			top = temp;
			top.setMin_node(temp);
		}
		else{
			if(min>value){
				temp.setNext(top);
				min = value;
				top = temp;
				top.setMin_node(temp);
			}
			else{
				temp.setNext(top);
				temp.setMin_node(top.getMin_node());
				top = temp;
				
			}
		}
	}
	
	public int pop(){
		if(top == null){
			System.out.println("The stack is empty");
			return -1;
		}
		else{
			int value = top.getValue();
			top = top.getNext();
			return value;
		}
	}
	
	public MinStackNode min(){
		System.out.println("The minimum value in stack is: "+top.getMin_node().getValue());
		return top.getMin_node();
	}
	
	
	public static void main(String args[]){
		Min_Stack ms = new Min_Stack();
		ms.push(8);
		ms.push(6);
		ms.push(3);
		ms.push(4);
		ms.push(2);
		ms.push(5);
		ms.min();
		ms.pop();
		ms.pop();
		ms.min();
		
		
	}
	
	
	

}






class MinStackNode{
	int value;
	MinStackNode next;
	MinStackNode min_node;
	
	public MinStackNode(int value){
		this.value = value;
		next = null;
		min_node = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MinStackNode getNext() {
		return next;
	}

	public void setNext(MinStackNode next) {
		this.next = next;
	}

	public MinStackNode getMin_node() {
		return min_node;
	}

	public void setMin_node(MinStackNode min_node) {
		this.min_node = min_node;
	}
	
	
	
}
