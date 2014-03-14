package CTCI;
import DataStructure.*;

public class Array_3_Stack {
	int stack_size = 100;
	int index_used = 0;
	int [] stackpointer = {-1,-1,-1};
	StackNode [] buffer = new StackNode[3 *stack_size];
	
	public void push(int stacknum , int value){
		int lastindex = stackpointer[stacknum];
		stackpointer[stacknum] = index_used;
		index_used++;
		buffer[stackpointer[stacknum]] = new StackNode(lastindex, value);
		
	}
	
	public int pop(int stacknum){
		if(stackpointer[stacknum] == -1){
			System.out.println("Stack "+ stacknum + " is empty");
			return -1;
		}
		else{
			int value = buffer[stackpointer[stacknum]].getValue();
			int lastindex = stackpointer[stacknum];
			stackpointer[stacknum] = buffer[stackpointer[stacknum]].getPrev();
			buffer[lastindex] = null;
			index_used --;
			return value;
			
		}
		
		
	}
	
	public static void main(String args[]){
		Array_3_Stack a3s = new Array_3_Stack();
		a3s.push(0,1);
		a3s.push(1,2);
		a3s.push(2,3);
		a3s.push(2,4);
		System.out.println(a3s.pop(2));
		System.out.println(a3s.pop(1));
		System.out.println(a3s.pop(0));
		System.out.println(a3s.pop(2));
	}
	
	
	
	

}

class StackNode{
	private int value;
	private int prev;
	
	public StackNode(int previous, int value){
		prev = previous;
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getPrev() {
		return prev;
	}
	
	public void setPrev(int prev) {
		this.prev = prev;
	}
	
}
