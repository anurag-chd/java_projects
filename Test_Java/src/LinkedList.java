

public class LinkedList<E>{
	Node head;
	
	public LinkedList(){
		head = null;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public void insert(E num){
		Node n = new Node(num);
		if(head == null){
			head = n;			
		}
		else{
			Node temp =  head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
	}
	
	public boolean delete(E num){
		if(head == null){
			System.out.println("The list is empty");
			return true;
		}
		else{
			if(head.getvalue() == num){
				System.out.println("The deleted node value is " + head.getvalue());
				head = head.getNext();
				return true;
			}
			else{
				Node temp = head;
				while(temp.getNext().getvalue() != num){
					temp = temp.getNext();
					if(temp.getNext() == null){
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
			while(temp.getNext()!=null){
				System.out.println(temp.getvalue());
				temp = temp.getNext();
			}
			System.out.println(temp.getvalue());
			
		}
		
	}
	
}