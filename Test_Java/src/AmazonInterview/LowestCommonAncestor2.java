package AmazonInterview;

import Basics.GenTreeNode;

public class LowestCommonAncestor2 {
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
		GenTreeNode<Integer> node2 = new GenTreeNode<Integer>(20);
		
		GenTreeNode<Integer> parent = findLCA(root, node1, node2);
		if(parent == null){
			System.out.println("Their is no common ancestor");
		}
		else{
			System.out.println("Common Ancestor  "+ parent.getData());
		}
		
	}
	
	public static GenTreeNode<Integer> findLCA(GenTreeNode root,GenTreeNode node1, GenTreeNode node2 ){
		if(root == null){
			return null;
		}
		else if(root.getData() == node1.getData() || root.getData() == node2.getData() ){
			return root;
		}
		else{
			if(isNodePresent(root.getLeft_child(),node1) && isNodePresent(root.getLeft_child(),node2)){
				return findLCA(root.getLeft_child(),node1,node2);
			}
			else if(isNodePresent(root.getLeft_child(),node1) || isNodePresent(root.getLeft_child(),node2)){
				return root;
			}
			else{
				return findLCA(root.getRight_child(),node1,node2);
			}
			//return null;
		}
	}
	
	public static boolean isNodePresent(GenTreeNode<Integer> root, GenTreeNode<Integer> node){
		if (root == null)
			return false;
		else if(root.getData() == node.getData() ){
			return true;
		}
		else{
			return (isNodePresent(root.getLeft_child(), node) || isNodePresent(root.getRight_child(), node));
		}
	}
	
	
}
