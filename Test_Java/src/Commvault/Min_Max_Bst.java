package Commvault;

import binaryTree.*;
public class Min_Max_Bst {
		static BinaryST new_btree = new BinaryST();
	public static void main(String args[]){
		BinaryST btree = new BinaryST();
		btree.root = btree.insert(15, btree.root);
		btree.root = btree.insert(10, btree.root);
		btree.root = btree.insert(12, btree.root);
		btree.root = btree.insert(6, btree.root);
		btree.root = btree.insert(7, btree.root);
		btree.root = btree.insert(9, btree.root);
		btree.root = btree.insert(20,btree.root);
		btree.root = btree.insert(16, btree.root);
		btree.root = btree.insert(21, btree.root);
		btree.root = btree.insert(23, btree.root);
		int min = 9;
		int max = 20;
		getMinMaxTree(btree.root, min, max);
		
		btree.printPreOrderTree(btree.root);
		System.out.println("New tree");
		new_btree.printPreOrderTree(new_btree.root);
	}
	
	public static void getMinMaxTree(TreeNode root,int min, int max){
		if(root == null){
			return;
		}
		else{
			if(root.getData()> min && root.getData() < max){
				new_btree.root= new_btree.insert(root.getData(), new_btree.root);
			}
			getMinMaxTree(root.getLeft_child(),min,max);
			getMinMaxTree(root.getRight_child(),min,max);
		}
	}
	
	
	

}
