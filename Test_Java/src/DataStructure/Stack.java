package DataStructure;

import Basics.*;

public class Stack <E> {
	Node top;
	public final int capacity;
	int size;
	public Stack(int capacity){
		this.capacity = capacity;
		size = 0;
	}
	public Stack(){
		this.capacity = 100;
		size = 0;
	}
	
	public void push(E item){
		if(size == capacity){
			System.out.println("Stack is full");
			return;
		}
		else{
			Node t = new Node(item);
			t.setNext(top);
			top = t;
			size++;
		}
		
	}	
	
	public E pop(){
		if(size == 0){
			System.out.println("List is empty");
			return null;
		}
		else{
			E item = (E)top.getvalue();
			top = top.getNext();
			size--;
			return item;
		}
	}
	
	public Node peek(){
		if(top == null){
			System.out.println("List is empty");
			return null;
		}
		else{
			E item = (E)top.getvalue();
			Node temp = top;
			//System.out.println(item);
			
			return temp;
		}
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	
}
