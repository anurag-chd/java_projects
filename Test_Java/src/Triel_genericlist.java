
public class Triel_genericlist {

	public static void main(String args[]){
		LinkedList l = new LinkedList();
		l.insert('a');
		l.insert('b');
		l.insert('c');
		l.insert('d');
		Node head = l.getHead();
		while(head!=null){
			System.out.println(head.getvalue());
			head = head.getNext();
		}
	}
}
