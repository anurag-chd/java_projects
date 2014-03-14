package AmazonInterview;

import Basics.GenTreeNode;
import binaryTree.BinaryST;
import binaryTree.TreeNode;

public class CheckBinaryTree {
	public static void main(String args[]){

		
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(5);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(9));
		root.getLeft_child().setLeft_child(new GenTreeNode(10));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode(2));
		root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode(1));
		root.getRight_child().setLeft_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(10));
		
		printInOrder(root);
		

		if(check(root)){
			System.out.println("BST");
		}
		else{
			System.out.println("No BST");
		}		
	}

	
	
	public static void printInOrder(GenTreeNode root){
		if(root == null){
			return;
		}
		else{
			printInOrder(root.getLeft_child());
			System.out.print(root.getData()+",");
			printInOrder(root.getRight_child());
		}
	}
	
	
	public static boolean check(GenTreeNode root){
		if(root == null){
			return true;
		}

	
			return (
					check(root.getLeft_child()) 
					&& 
					check(root.getRight_child()) 
					&&
					(root.getLeft_child() == null?true:((Integer)root.getData()>(Integer)root.getLeft_child().getData()) )
					&& 
					( root.getRight_child() == null?true:((Integer)root.getData()<(Integer)root.getRight_child().getData()) )
					) ;
	}

	
	
	
	
}
