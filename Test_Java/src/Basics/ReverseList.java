package Basics;

public class ReverseList {
		public static void main(String args[]){
			LinkedList<Integer> list1 = new LinkedList<Integer>();
			list1.insert(1);
			list1.insert(2);
			list1.insert(3);
			list1.insert(4);
			list1.insert(5);
			list1.insert(6);
			ReverseList rl = new ReverseList();
			rl.reverse(list1);

			
		}
		
		
		public void reverse(LinkedList l){
			Node<Integer> parent = l.getHead();
			Node<Integer> child = parent.getNext();
			if(parent == l.getHead()){
				parent.setNext(null);
			}
			while(child!=null){
				Node<Integer> temp = child;
				child= child.getNext();
				temp.setNext(parent);
				parent = temp;
			}
			l.setHead(parent);
			Node<Integer> temp = l.getHead();
			while(temp!=null){
				System.out.println(temp.getvalue());
				temp = temp.getNext();
			}
		}
}
