package CTCI;
import Basics.*;

public class Del_Access_Node {
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(7);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		Node node = list.getHead().getNext().getNext().getNext();
		Del_Access_Node dan = new Del_Access_Node();
		dan.delete(node);
	}
	
	public void delete(Node node){
		Node temp = node;
		if(node == null || node.getNext() == null ){
			return;
		}
		else{
			while(node.getNext().getNext()!=null){
				if(node.getNext()==null){
					node= null; 
				}
				else{
					node.setvalue(node.getNext().getvalue());
					node = node.getNext();
				}
			}
			node.setvalue(node.getNext().getvalue());
			node.setNext(null);
			while(temp!=null){
				System.out.println(temp.getvalue());
				temp = temp.getNext();
			}
				
		}
	}
}
