package CTCI;

import Basics.*;
import java.util.HashMap;
public class Delete_Dup_Linked_list1 {
	
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(7);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		Delete_Dup_Linked_list1 ddll = new Delete_Dup_Linked_list1();
		list = ddll.removeDup(list);
		Node temp = list.getHead();
		while(temp!=null){
			System.out.println(temp.getvalue());
			temp = temp.getNext();
		}
		
		
	}
	
	public LinkedList removeDup(LinkedList list){
		HashMap<Integer,Boolean> list_map = new HashMap<Integer,Boolean>();
		Node head = list.getHead();
		Node temp = head;
		Node temp2 = head;
		while(temp2!=null){
			list_map.put((int)temp2.getvalue(), false);
			temp2 = temp2.getNext();
		}
		while(temp!=null){
			if(list_map.get(temp.getvalue())){
				list.delete(temp.getvalue());
			}
			else{
				list_map.put((int)temp.getvalue(), true);
			}
			temp = temp.getNext();
		}
		return list;
		
	}
}
