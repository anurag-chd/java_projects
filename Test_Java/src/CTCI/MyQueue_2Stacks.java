package CTCI;
import DataStructure.*;

public class MyQueue_2Stacks {
	Stack<Integer> s1;
	Stack<Integer> s2;
	int capacity ;
	
	public MyQueue_2Stacks(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void enqueue(int num){
		s1.push(num);
	}
	
	public int dequeue(){
		if(s2.isEmpty()){
			if(s1.isEmpty()){
				System.out.println("Stack is empty");
				return -1;
			}
			else{
				while(!s1.isEmpty()){
					int item = s1.pop();
					s2.push(item);
				}
				return s2.pop();
			}
			
		}
		else{
			return s2.pop();
		}
		
	}
	
	public static void main(String args[]){
		Queue<Integer> q = new Queue<Integer>();
		MyQueue_2Stacks mq2s = new MyQueue_2Stacks();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		mq2s.enqueue(1);
		mq2s.enqueue(2);
		mq2s.enqueue(3);
		mq2s.enqueue(4);
		mq2s.enqueue(5);
		System.out.println("q1 dequeue: " +q.dequeue());
		System.out.println("mq2s dequeue: "+ mq2s.dequeue());
		System.out.println("q1 dequeue: " +q.dequeue());
		System.out.println("mq2s dequeue: "+ mq2s.dequeue());
		System.out.println("q1 dequeue: " +q.dequeue());
		System.out.println("mq2s dequeue: "+ mq2s.dequeue());
		System.out.println("q1 dequeue: " +q.dequeue());
		System.out.println("mq2s dequeue: "+ mq2s.dequeue());
	}
	
	
	

}
