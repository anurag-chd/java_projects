package Basics;

public class DoublyLinkedList {
	Dnode head;
	
	public DoublyLinkedList(){
		head = null;
	}
	
	public void insert(int num){
		Dnode dn = new Dnode(num);
		if(head == null){
			head = dn;
		}
		else{
			Dnode temp = head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(dn);
			dn.setPrev(temp);
		}
	}

	public boolean delete(int num){
	if(head == null){
		System.out.println("The list is empty");
		return true;
	}
	else{
		if(head.getData() == num){
			System.out.println("The element deleted is "+ head.getData());
			head = head.getNext();
			head.setPrev(null);
			return true;
		}
			
		else{
			Dnode temp = head;
			while(temp.getNext().getData()!=num){
				temp = temp.getNext();
				if(temp.getNext()==null){
					System.out.println("The item is not present");
					return true;
					
				
				}
			}
			System.out.println("The element deleted is "+ temp.getNext().getData());
			if(temp.getNext().getNext()==null){
				temp.setNext(null);
				return true;
			}
				
			else{
			temp.setNext(temp.getNext().getNext());
			temp.getNext().setPrev(temp);
			return true;
			}
		}
	}
	}
	
	public void showList(){
		if (head == null){
			System.out.println("The list is empty");
		}
		else{
		Dnode temp = head;
		while(temp.getNext()!=null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	
		}
	}
	public void showReverseList(){
		if(head == null){
			System.out.println("The list is empty");
		}
		else{
			Dnode temp = head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			while(temp.getPrev()!=null){
				System.out.println(temp.getData());
				temp = temp.getPrev();
			}
			System.out.println(temp.getData());
			
		}
	}
	
}

