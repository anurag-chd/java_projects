import java.util.*;
import java.lang.*;



 class Node{
	int data;
	Node next;
	

public Node(int num ){
	this.data = num;
	this.next = null;
	
}

public Node(){
	//this.data = null;
	this.next = null;
	
}





 
 }
public class LinkedList {
	Node head = null;
	
	
	

	public void addNode(int data){
		Node node = new Node(data);
		if(head==null){
			head = node;
		}
		else{
			Node temp = head;
			while(temp.next !=null)
				temp=temp.next;
			temp.next=node;
			node.next= null;
		}
			
	}
	
	public void delNode(int data){
		if (head.data==data){
		System.out.println("hii");
			head=head.next;
		}
		else{
			Node temp = head;
			while(temp.next.data!=data){
				temp=temp.next;
				}
			temp.next=temp.next.next;
		}
	}
	
	public void printList(){
		Node temp = head;
		while(temp.next!=null){
			System.out.println("The element of node"+temp.data);
			temp=temp.next;
		}
		System.out.println("The element of node"+temp.data);
	}
	
	
	public static void main(String[] args ){
		
	//System.out.println("Hii");	
		
	LinkedList node = new LinkedList();
	//LinkListNode head = node;
	//System.out.println(node.data);
	node.addNode(2);
	node.addNode(8);
	node.printList();
	node.delNode(2);
	node.printList();
	node.addNode(5);
	node.printList();
	node.delNode(5);
	node.printList();

	}

}
