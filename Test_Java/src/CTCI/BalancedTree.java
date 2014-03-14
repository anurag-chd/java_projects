package CTCI;
import java.io.*;

import Basics.*;
public class BalancedTree {
	
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		//root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode('e'));
		root.getRight_child().setLeft_child(new GenTreeNode('f'));
		
		BalancedTree bt = new BalancedTree();
		if(bt.findBalance(root)){
			System.out.println("The Tree is Balanced");
		}
		else{
			System.out.println("The Tree is Imbalanced");
		}
		
	}
	public boolean findBalance(GenTreeNode root){
		int max_height = findMaxHeight(root);
		int min_height = findMinHeight(root);
		System.out.println("MAX height: "+max_height);
		System.out.println("MIN height: "+min_height);
		if(max_height - min_height <=1){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public int findMaxHeight(GenTreeNode<Character> root){
		if (root == null){
			return 0;
		}
		else{
			return (1 + Math.max(findMaxHeight(root.getLeft_child()), findMaxHeight(root.getRight_child())));
		}
	}
	
	public int findMinHeight(GenTreeNode<Character> root){
		if (root == null){
			return 0;
		}
		else{
			return (1 + Math.min(findMinHeight(root.getLeft_child()), findMinHeight(root.getRight_child())));
		}
	}
	

}
