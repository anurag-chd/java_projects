
class CircularLinkedList<E> {
	Node head;
	
	public CircularLinkedList() {
		// TODO Auto-generated constructor stub
	head = null;
	}
	
	public void insert(E num){
		Node n = new Node(num);
		if(head == null){
			head = n;
			head.setNext(head);
		}
		else{
			Node temp =  head;
			while(temp.getNext()!=head){
				temp = temp.getNext();
			}
			temp.setNext(n);
			n.setNext(head);
		}
	}
	
	
	public boolean delete(E num){
		if(head == null){
			System.out.println("The list is empty");
			return true;
		}
		else{
			if(head.getvalue() == num){
				Node temp1 = head;
				System.out.println("The deleted node value is " + head.getvalue());
				head = head.getNext();
				Node temp2 = head;
				while(temp2.getNext()!=temp1){
					temp2 = temp2.getNext();
				}
				temp2.setNext(head);
				return true;
			}
			else{
				Node temp = head;
				while(temp.getNext().getvalue() != num){
					temp = temp.getNext();
					if(temp.getNext() == head){
						System.out.println("The value is not in list");
						
						return true;
					}
					
				}
				System.out.println("The deleted node value is " + temp.getNext().getvalue());
				temp.setNext(temp.getNext().getNext());
				
				return true;
			}
		
		}
			
	}

	public void showList(){
		if (head == null){
			System.out.println("The list is empty");
		}
		else{
			Node temp = head;
			while(temp.getNext()!=head){
				System.out.println(temp.getvalue());
				temp = temp.getNext();
			}
			System.out.println(temp.getvalue());
		}
		
	}
	
	
	
	
}
