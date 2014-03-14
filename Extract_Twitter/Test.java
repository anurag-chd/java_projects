import java.util.*;
import java.lang.*;



public class LinkListNode{
	int data;
	LinkeListNode next;
	}

public LinkedListNode(int num,LinkedListNode n ){
	this.data = num;
	this.next = n;
}

public void addNode(int data){
	LinkedListNode node = this;
	While(n != null)
	if(n.next==null){
		LinkedListNode node = new LinkedListNode(data, null);
		n.next = node
	}
	n=n.next;
}

public class Test{
	public static void main(String args []){
		
	
	
	LinkListNode node = new LinkListNode(5,null)
	node.addNode(2);
	System.out.println("The List is")
	while(node!=null){
		 System.out.println(node.data);
	node = node.next;
	}

	}
}