package CTCI;

import Basics.*;
public class Sorted_Array_Min_Depth_BSTree {
	
	public static void main(String args[]){
		int [] arr = {1,2,3,4,5,6,7,8,9,10};
		
		Sorted_Array_Min_Depth_BSTree samdb = new Sorted_Array_Min_Depth_BSTree();
		GenTreeNode<Integer> root = samdb.convertToBtree(arr,0,arr.length-1);
		BalancedTree bt = new BalancedTree();
		if(bt.findBalance(root)){
			System.out.println("The Tree is Min Tree");
		}
		else{
			System.out.println("The Tree is not Min Tree");
		}
		
	}
	
	public GenTreeNode<Integer> convertToBtree(int []arr, int start, int end){
		if(end<start){
			return null;
		}
		else{
			int mid = (start + end) / 2;
			GenTreeNode<Integer> root = new GenTreeNode<Integer>(arr[mid]);
			root.setLeft_child(convertToBtree(arr,start,mid-1));
			root.setRight_child(convertToBtree(arr,mid+1,end));
			
			return root;
		}
		
		
	}

}
