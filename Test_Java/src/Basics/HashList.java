package Basics;

public class HashList {
HashNode head;
	
	public HashList(){
		head = null;
	}
	
	public void insert(int key, int value){
		HashNode n = new HashNode(key,value);
		if(head == null){
			head = n;			
		}
		else{
			HashNode temp =  head;
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(n);
		}
	}
	/*
	public boolean delete(int num){
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
	*/
	public void showList(){
		if (head == null){
			System.out.println("The list is empty");
		}
		else{
			HashNode temp = head;
			while(temp.getNext()!=null){
				System.out.println("Key="+temp.getKey()+" Value = "+temp.getValue());
				temp = temp.getNext();
			}
			System.out.println("Key="+temp.getKey()+" Value = "+temp.getValue());
			
		}
		
	}


}
