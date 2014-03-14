package CTCI;

//import binaryTree.*;
import Basics.*; 
import Basics.LinkedList;
import DataStructure.*;
import DataStructure.Queue;

import java.util.*;

public class Level_LinkedList_BTree {
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
		btree.root = btree.insert(25, btree.root);
		btree.root = btree.insert(28, btree.root);
		btree.root = btree.insert(30, btree.root);
		
		Level_LinkedList_BTree l3bt = new Level_LinkedList_BTree();
		ArrayList<java.util.LinkedList<TreeNode>> node_list = new ArrayList<java.util.LinkedList<TreeNode>>();
		node_list = l3bt.getList(btree.root);
		Iterator i = node_list.iterator();
		while(i.hasNext()){
			java.util.LinkedList<TreeNode> list = (java.util.LinkedList<TreeNode>)i.next();
			Iterator i1 = list.iterator();
			while(i1.hasNext()){
				TreeNode t =(TreeNode)i1.next();
				System.out.print(t.getData()+" ");
			}
			System.out.println();
		}
		
	}
	
	public ArrayList<java.util.LinkedList<TreeNode>> getList(TreeNode root){
		ArrayList<java.util.LinkedList<TreeNode>> result_list = new ArrayList<java.util.LinkedList<TreeNode>>();
		java.util.LinkedList<TreeNode> level0_list = new java.util.LinkedList<TreeNode>();
		level0_list.add(root);
		result_list.add(level0_list);
		int level = 0;
		
		while(true){
			java.util.LinkedList<TreeNode> upperLevel = result_list.get(level);
			java.util.LinkedList<TreeNode> leveli = new java.util.LinkedList<TreeNode>();
			for(int i =0 ; i<upperLevel.size(); i++){
				TreeNode temp = upperLevel.get(i);
				if(temp.getLeft_child()!=null){
					leveli.add(temp.getLeft_child());
				}
				if(temp.getRight_child()!=null){
					leveli.add(temp.getRight_child());
				}
			}
			if(!leveli.isEmpty()){
				result_list.add(leveli);
				level++;
			}
			else{
				break;
			}
			
			
		}
		
		return result_list;
	}
	
	
}
