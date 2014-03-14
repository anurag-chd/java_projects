package CTCI;

import Basics.TreeNode;

public class InOrderSuccessor {
	
	public static void main(String args[]){
		BSTree bst = new BSTree();
		bst.root = bst.insert(15, bst.root);
		bst.root = bst.insert(10, bst.root);
		bst.root = bst.insert(12, bst.root);
		bst.root = bst.insert(6, bst.root);
		bst.root = bst.insert(7, bst.root);
		bst.root = bst.insert(9, bst.root);
		bst.root = bst.insert(20,bst.root);
		bst.root = bst.insert(16, bst.root);
		bst.root = bst.insert(21, bst.root);
		bst.root = bst.insert(23, bst.root);
		bst.root = bst.insert(25, bst.root);
		bst.root = bst.insert(28, bst.root);
		bst.root = bst.insert(30, bst.root);
		bst.printInOrderTree(bst.root);
		
		InOrderSuccessor ios = new InOrderSuccessor();
		/*SuccTreeNode successor = ios.getSuccessor(bst.root.getLeft_child().getLeft_child().getRight_child());
		System.out.println(bst.root.getLeft_child().getLeft_child().getRight_child().getData());
		System.out.println(successor.getData());*/
		SuccTreeNode successor = ios.getSuccessor(bst.root);
		System.out.println(bst.root.getData());
		System.out.println(successor.getData());
	}
	
	public SuccTreeNode getSuccessor(SuccTreeNode e){
		if(e!=null){
			if(e.getParent() == null || e.getRight_child()!=null){
				return getLeftMostChild(e.getRight_child());
			}
			else{
				SuccTreeNode parent ;
				while((parent= e.getParent())!=null){
					if(parent.getLeft_child() == e){
						return parent;
					}
				}
				return parent;
			}
		}
		else
			return null;
	}
	
	public SuccTreeNode getLeftMostChild(SuccTreeNode node){
		if(node == null){
			return null;
		}
		else{
			while(node.getLeft_child()!=null){
				node = node.getLeft_child();
			}
			return node;
		}
	}
		
	
	

}

class BSTree{
	 SuccTreeNode root;
	
	public BSTree(){
		root = null;
	}
	public BSTree(SuccTreeNode root){
		this.root = root ;
	}
	
	public void setRoot(SuccTreeNode root){
		this.root = root;
	}
	public SuccTreeNode getRoot(){
		return root;
	}
	
	public SuccTreeNode insert( int num,SuccTreeNode root){
		SuccTreeNode temp2 = root;
		if(root == null){
			SuccTreeNode temp = new SuccTreeNode(num);
			root = temp;
			return root;
		}
		else{
			if(num>temp2.getData()){
				SuccTreeNode temp = insert(num,root.getRight_child());
				root.setRight_child(temp);
				temp.setParent(root);
			}
			else{
				SuccTreeNode temp = insert(num,root.getLeft_child());
				root.setLeft_child(temp);
				temp.setParent(root);
			}
			return root;
		}
	}
	
	public SuccTreeNode delete(SuccTreeNode root, int num){
		if(root == null){
			return null;
		}
		else{
			if(root.getData() == num){
				if(root.getLeft_child() == null && root.getRight_child() == null){
					root = null;
					return root;
				}
				else if(root.getLeft_child() == null){
					root = getRightChild_LeftMost(root);
					return root;
				}
				else{
					root = getLeftChild_RightMost(root);
					return root;
				}
			}
			else if(root.getData() > num){
				root.setLeft_child(delete(root.getLeft_child(),num));
				return root;
			}
			else{
				root.setRight_child(delete(root.getRight_child(),num));
				return root;
			}
		}
	}
	
	public SuccTreeNode getRightChild_LeftMost(SuccTreeNode root){
		SuccTreeNode first_right = root.getRight_child();
		if(first_right.getLeft_child() == null){
			first_right.setLeft_child(root.getLeft_child());
			return root;
		}
		else{
			SuccTreeNode parent = first_right;
			SuccTreeNode child = first_right.getLeft_child();
			while(child.getLeft_child()!=null){
				parent = child;
				child = child.getLeft_child();
			}
			parent.setLeft_child(child.getRight_child());
			child.setLeft_child(root.getLeft_child());
			child.setRight_child(root.getRight_child());
			return child;
		}
	}
	
	public SuccTreeNode getLeftChild_RightMost(SuccTreeNode root){
		SuccTreeNode first_left = root.getLeft_child();
		if(first_left.getRight_child() == null){
			first_left.setRight_child(root.getRight_child());
			return root;
		}
		else{
			SuccTreeNode parent = first_left;
			SuccTreeNode child = first_left.getRight_child();
			while(child.getRight_child()!=null){
				parent = child;
				child = child.getRight_child();
			}
			parent.setLeft_child(child.getLeft_child());
			child.setLeft_child(root.getLeft_child());
			child.setRight_child(root.getRight_child());
			return child;
		}
	}
	
	
	public void printInOrderTree(SuccTreeNode tn){
		/*if(tn == null){
			System.out.println("Tree has no elements");
		}*/
		if(tn!=null){
			printInOrderTree(tn.getLeft_child());
			System.out.println(tn.getData());
			printInOrderTree(tn.getRight_child());
			
		}
	}
	
	
	
	
}








class SuccTreeNode {

	private int data;
	private SuccTreeNode left_child;
	private SuccTreeNode right_child;
	private SuccTreeNode parent;
	
	public SuccTreeNode getParent() {
		return parent;
	}

	public void setParent(SuccTreeNode parent) {
		this.parent = parent;
	}

	public SuccTreeNode(int num){
		this.data = num;
		left_child = null;
		right_child = null;
		parent = null;
	}
		
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public SuccTreeNode getLeft_child() {
		return left_child;
	}

	public void setLeft_child(SuccTreeNode left_child) {
		this.left_child = left_child;
	}

	public SuccTreeNode getRight_child() {
		return right_child;
	}

	public void setRight_child(SuccTreeNode right_child) {
		this.right_child = right_child;
	}

	
	
}