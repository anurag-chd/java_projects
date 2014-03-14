package AmazonInterview;

import java.util.ArrayList;
import java.util.Collections;

import Basics.GenTreeNode;

public class LowestCommonAncestor {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(5);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(9));
		root.getLeft_child().setLeft_child(new GenTreeNode(10));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode(2));
		root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode(1));
		root.getRight_child().setLeft_child(new GenTreeNode(18));
		root.getRight_child().setRight_child(new GenTreeNode(20));
		
		GenTreeNode<Integer> node1 = new GenTreeNode<Integer>(1);
		GenTreeNode<Integer> node2 = new GenTreeNode<Integer>(2);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1 =	getPath(root, node1,list1);
		list2 = getPath(root, node2,list2);
		for(int i : list1){
			System.out.print(i+",");
		}
		System.out.println();
		
		for(int j : list2){
			System.out.print(j+",");
		}
		
		
		GenTreeNode<Integer> parent = findLCA(root, node1, node2);
		if(parent == null){
			System.out.println("Their is no common ancestor");
		}
		else{
			System.out.println("Common Ancestor  "+ parent.getData());
		}
	}
	
	public static GenTreeNode<Integer> findLCA(GenTreeNode<Integer> root, GenTreeNode<Integer> node1, GenTreeNode<Integer> node2){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list1 =	getPath(root, node1,list1);
		list2 = getPath(root, node2, list2);
		int count = -1;
		if(list1 == null || list2 == null){
			return null;
		}
		for(int i = 0, j =0; i<list1.size() && j< list2.size() ;i++,j++){
			if(list1.get(i)== list2.get(j)){
				count = list1.get(i);
			}
			else{
				break;
			}
		}
		if(count == -1 ){
			return null;
		}
		else{
			return new GenTreeNode<Integer>(count);
		}
		
	}
	
	
	
	public static ArrayList<Integer> getPath(GenTreeNode<Integer> root, GenTreeNode<Integer> node,ArrayList<Integer> list){
		if(root == null){
			list = null;
			return list;
		}
		else{
			if(root.getData() == node.getData()){
				list.add(root.getData());
				return list;
			}
			else{
				list.add(root.getData());
				ArrayList<Integer> l1 = (ArrayList<Integer>)list.clone();
				ArrayList<Integer> l2 = (ArrayList<Integer>)list.clone();
				
				l1 = getPath(root.getLeft_child(),node,l1);
				l2 = getPath(root.getRight_child(),node,l2);
				if(l1 != null){
					return l1;
				}
				else{
					return l2;
				}
				
				
				//return list;
				/*list.add(list, getPath(root.getLeft_child(),node,list));
				Collections.addAll(list, getPath(root.getLeft_child(),node,list));
				*/
			}
			
		}
		
		
		
	}
	
	
	
	
}
