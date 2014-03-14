package DataStructure;
import Basics.*;

public class Queue<E> {
	Node first;
	Node last;
	int size = 0;
	
	public void enqueue(E item){
		if(first == null){
			Node t = new Node(item);
			
			last = t;
			first = t;
			
		}
		else{
			Node t = new Node(item);
			last.setNext(t);
			last = t;
		}
		size++;
	}
	
	public E dequeue(){
		if(size == 0){
			System.out.println("The queue is empty");
			return null;
		}
		else{
			E item = (E)first.getvalue();
			first = first.getNext();
			size--;
			return item;
		}
	}
	
	public boolean isEmpty(){
		return (size == 0);
	}
	
public static void main(String args[]){
	Stack st = new Stack();
	Queue q = new Queue<>();
	st.push(4);
	st.push(5);
	st.push(6);
	st.push(7);
	q.enqueue(4);
	q.enqueue(5);
	q.enqueue(6);
	q.enqueue(7);
	System.out.println(st.pop() + " " + q.dequeue());
	System.out.println(st.pop() + " " + q.dequeue());
	System.out.println(st.pop() + " " + q.dequeue());
	System.out.println(st.pop() + " " + q.dequeue());
	System.out.println(st.pop() + " " + q.dequeue());
}



}
