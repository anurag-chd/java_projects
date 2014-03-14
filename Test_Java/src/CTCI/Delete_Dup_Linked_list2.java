package CTCI;
import Basics.*;

public class Delete_Dup_Linked_list2 {
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
		Delete_Dup_Linked_list2 ddll2 = new Delete_Dup_Linked_list2();
		list = ddll2.removeDup(list);
		Node temp = list.getHead();
		while(temp!=null){
			System.out.println(temp.getvalue());
			temp = temp.getNext();
		}
	}
	
	public LinkedList removeDup(LinkedList list){
		if(list == null){
			return list;
		}
		else{
			Node prev = list.getHead();
			Node curr = prev.getNext();
			while(curr!=null){
				Node runner = list.getHead();
				while(runner != curr){
					if(runner.getvalue() == curr.getvalue()){
						prev.setNext(curr.getNext());
						curr = curr.getNext();
						break;
					}
					runner = runner.getNext();
						
				}
				if(runner == curr){
					prev = curr;
					curr = curr.getNext();
				}
				
			}
			return list;
		}
		
	}
	
	
}
