package CTCI;

import Basics.*;

public class AddList {
	public static void main(String args[]){
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.insert(8);
		list1.insert(1);
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.insert(1);
		list2.insert(8);
		AddList al = new AddList();
		LinkedList list3 = al.add(list1,list2);
		Node head3 = list3.getHead();
		while(head3!=null){
			System.out.println(head3.getvalue());
			head3 = head3.getNext();
		}
	}
	
	public LinkedList add(LinkedList list1, LinkedList list2){
		LinkedList list3 = new LinkedList();
		int temp = 0;
		Node head1 = list1.getHead();
		Node head2 = list2.getHead();
		while(head1!=null || head2!=null){
			int sum=0;
			if(head1 == null){
				sum = temp + (int)head2.getvalue();	
				if(sum <10){
					temp = 0;
					list3.insert(sum);
				}
				else{
					temp = 1;
					list3.insert(sum%10);
				}
				head2 = head2.getNext();
			}
			if(head2 == null){
				sum = temp + (int)head1.getvalue();	
				if(sum <10){
					temp = 0;
					list3.insert(sum);
				}
				else{
					temp = 1;
					list3.insert(sum%10);
				}
				head1 = head1.getNext();
			}
			else{
				sum = temp + (int)head1.getvalue() + (int)head2.getvalue();
				if(sum <10){
					temp = 0;
					list3.insert(sum);
				}
				else{
					temp = 1;
					list3.insert(sum%10);
				}
				head1 = head1.getNext();
				head2 = head2.getNext();
			}
			
			
		}
		
		if(temp>0){
			list3.insert(temp);
		}
		
		return list3;
	}
}
