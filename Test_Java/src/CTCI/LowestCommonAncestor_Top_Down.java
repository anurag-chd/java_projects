package CTCI;

import Basics.GenTreeNode;

public class LowestCommonAncestor_Top_Down {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode<Character>('b'));
		root.setRight_child(new GenTreeNode<Character>('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode<Character>('e'));
		root.getRight_child().setLeft_child(new GenTreeNode<Character>('f'));
		root.getLeft_child().setRight_child(new GenTreeNode<Character>('g'));
		
		LowestCommonAncestor_Top_Down lca_td = new LowestCommonAncestor_Top_Down();
		GenTreeNode<Character> ancestor = lca_td.find(root,root.getLeft_child().getLeft_child().getLeft_child(), root.getRight_child().getLeft_child());
		
		System.out.println("Child 1 "+ root.getLeft_child().getLeft_child().getLeft_child().getData()+ " Child2 "+root.getLeft_child().getRight_child().getData() );
		System.out.println("Ancestor:"+ancestor.getData());
	}
	
	public GenTreeNode<Character> find(GenTreeNode root, GenTreeNode A, GenTreeNode B){
		if(root == null || A == null || B == null){
			return null;
		}
		else{
			if(covers(root.getLeft_child(),A) && covers(root.getLeft_child(),B))
				return find(root.getLeft_child(),A,B);
			if(covers(root.getRight_child(),A) && covers(root.getRight_child(),B))
				return find(root.getRight_child(),A,B);
			return root;
		}
	}
	
	public boolean covers(GenTreeNode root, GenTreeNode A){
		if(root == null)
			return false;
		if(root == A){
			return true;
		}
		else{
			return (covers(root.getLeft_child(),A) || covers(root.getRight_child(),A));
		}
	}
	
}
