package Basics;

public class Dnode {

	int data;
	Dnode next;
	Dnode prev;
	
	public Dnode(int num){
		this.data = num;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Dnode getNext() {
		return next;
	}

	public void setNext(Dnode next) {
		this.next = next;
	}

	public Dnode getPrev() {
		return prev;
	}

	public void setPrev(Dnode prev) {
		this.prev = prev;
	}

	
	
	
	
	
	
	
	
	
	
	
}
