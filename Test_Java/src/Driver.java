
public class Driver {
public static void main(String args[]){
	LinkedList l = new LinkedList();
/*	l.insert(12);
	l.insert(13);
	l.insert(14);
	l.delete(12);
	l.showList();
	l.insert(12);
	l.showList();
	l.delete(14);
	l.showList();
	*/
	CircularLinkedList cl = new CircularLinkedList();
	/*cl.insert(12);
	cl.insert(13);
	cl.insert(14);
	cl.delete(14);
	cl.showList();
	cl.insert(12);
	cl.showList();
	cl.delete(14);
	cl.showList();
	*/
	DoublyLinkedList dl = new DoublyLinkedList();
	/*dl.insert(12);
	dl.insert(13);
	dl.insert(14);
	dl.showList();
	dl.showReverseList();
	dl.delete(14);
	dl.showList();
	dl.showReverseList();
	dl.insert(12);
	dl.showList();
	dl.showReverseList();
	dl.delete(14);
	dl.showList();
	dl.showReverseList();*/
	
	BinaryST bt = new BinaryST();
	bt.root = bt.insert(12, bt.root);
	bt.root = bt.insert(5, bt.root);
	bt.root = bt.insert(20, bt.root);
	bt.root = bt.insert(19, bt.root);
	bt.root = bt.insert(21, bt.root);
	bt.root = bt.insert(9, bt.root);
	bt.root = bt.insert(15, bt.root);
	bt.root = bt.insert(2, bt.root);
	
	bt.printInOrderTree(bt.root);
	bt.printPostOrderTree(bt.root);
	bt.printPreOrderTree(bt.root);
	/*
	bt.root = bt.delete(12,bt.root);
	bt.printInOrderTree(bt.root);
	bt.root = bt.delete(20,bt.root);
	bt.printInOrderTree(bt.root);
	bt.root = bt.delete(5,bt.root);
	bt.printInOrderTree(bt.root);
	*/
	
	
	/*System.out.println(bt.root.getData());
	System.out.println(bt.root.getLeft_child().getData());
	System.out.println(bt.root.getRight_child().getData());
	System.out.println(bt.root.getRight_child().getLeft_child().getData());
	*/
}
}
