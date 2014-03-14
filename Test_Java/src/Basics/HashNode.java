package Basics;

public class HashNode {
	 HashNode next;
	 int key;
	 int value;
	 
	 public HashNode(int key,int value){
		 this.key = key;
		 this.value = value;
	 }

	public HashNode getNext() {
		return next;
	}

	public void setNext(HashNode next) {
		this.next = next;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	 
	 

}
