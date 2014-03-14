package CTCI;
import Basics.*;

public class CircularList_Begining {
	public static void main(String args[]){
	LinkedList list1 = new LinkedList();
	list1.insert(1);
	list1.insert(2);
	
	CircularLinkedList cl = new CircularLinkedList();
	//cl.insert(3);
	cl.insert(4);
	cl.insert(5);
	cl.insert(6);
	cl.insert(7);
	cl.insert(8);
	Node head = list1.getHead();
	Node temp = head;
	while(temp.getNext()!=null){
		temp = temp.getNext();
	}
	temp.setNext(cl.getHead());
	
	CircularList_Begining clb = new CircularList_Begining();
	clb.findBegining(head);
	}
	
	public void findBegining(Node head){
		Node head1 = head;
		Node head2 = head;
		
		while(head1.getNext()!=null){
			head1 = head1.getNext();
			head2 = head2.getNext().getNext();
			if(head1.getvalue() == head2.getvalue()){
				break;
			}
		}
		
		head1 = head;
		while(head1.getvalue() != head2.getvalue()){
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
		System.out.println(head1.getvalue());
	}

}
