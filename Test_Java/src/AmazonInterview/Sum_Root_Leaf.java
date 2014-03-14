package AmazonInterview;

import Basics.GenTreeNode;

public class Sum_Root_Leaf {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(5);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(9));
		root.getLeft_child().setLeft_child(new GenTreeNode(10));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode(2));
		root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode(1));
		root.getRight_child().setLeft_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(10));
		
		int sum = 24;
		if(check(root,sum)){
			System.out.println("Sum exist");
		}
		else{
			System.out.println("Not");
		}
	}
	
	public static boolean check(GenTreeNode<Integer> root , int sum){
		if(root == null){
			return sum==0;
		}
		else{
			boolean result = false;
			int subsum = sum - root.getData();
			if(root.getLeft_child() == null && root.getRight_child() == null && subsum == 0){
				return true;
			}
			if(root.getLeft_child()!=null){
				result = result || check(root.getLeft_child(),subsum);
			}
			if(root.getRight_child()!=null){
				 result = result || check(root.getRight_child(),subsum);
			}
			
				return result;
			}
	
	}
}
