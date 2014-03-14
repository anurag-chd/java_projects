package CTCI;
import Basics.*;
public class N_LastNode {
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
		N_LastNode nln = new N_LastNode();
		nln.find(list,4);
		
	}
	
	public void find(LinkedList list, int n){
		Node first = list.getHead();
		Node second = list.getHead();
		for(int i = 0 ; i<n-1 ;i++){
			if(second == null){
				System.out.println("List is small then size of" +n);
				return;
			}
			else{
				second = second.getNext();
			}
			
		}
		while(second.getNext()!=null){
			second =second.getNext();
			first = first.getNext();
		}
		System.out.println(first.getvalue());
	}

}
