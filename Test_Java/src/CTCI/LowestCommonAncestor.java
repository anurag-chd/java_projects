package CTCI;

import Basics.GenTreeNode;
import java.util.*;

public class LowestCommonAncestor {

	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode<Character>('b'));
		root.setRight_child(new GenTreeNode<Character>('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode<Character>('e'));
		root.getRight_child().setLeft_child(new GenTreeNode<Character>('f'));
		root.getLeft_child().setRight_child(new GenTreeNode<Character>('g'));
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		GenTreeNode<Character> ancestor =lca.findLCA(root,root.getLeft_child().getLeft_child().getLeft_child(), root.getRight_child().getLeft_child());
		System.out.println("Child 1 "+ root.getLeft_child().getLeft_child().getLeft_child().getData()+ " Child2 "+root.getLeft_child().getRight_child().getData() );
		System.out.println("Ancestor:"+ancestor.getData());
	}
	
	public GenTreeNode<Character> findLCA(GenTreeNode root, GenTreeNode A, GenTreeNode B){
		ArrayList<GenTreeNode> inorder_list = new ArrayList<GenTreeNode>() ;
		ArrayList<GenTreeNode> postorder_list = new ArrayList<GenTreeNode>();
		
		inorder_list = getInorder(root,inorder_list);
		postorder_list = getPostorder(root,postorder_list);
		
		/*for(GenTreeNode t : inorder_list){
			System.out.print(t.getData()+" ");
		}
		System.out.println();
		
		for(GenTreeNode t : postorder_list){
			System.out.print(t.getData()+" ");
		}
		*/
		int a_in_index = inorder_list.indexOf(A);
		int b_in_index = inorder_list.indexOf(B);
		int a_post_index =postorder_list.indexOf(A);
		int b_post_index =postorder_list.indexOf(B);
		int dif_in = a_in_index - b_in_index;
		int dif_post = a_post_index - b_post_index;
		List<GenTreeNode> in_list;
		if(dif_in>0){
			in_list = inorder_list.subList(b_in_index, a_in_index+1);
		}
		else{
			in_list = inorder_list.subList(a_in_index, b_in_index+1);
		}
		int compare;
		if(dif_post>0)
			compare = a_post_index;
		else
			compare = b_post_index;
		
		for(GenTreeNode t : in_list){
			if(postorder_list.indexOf(t) > compare){
				return t;
			}
			
		}
		return null;
		
		
		
		 
		
	}
	
	public ArrayList<GenTreeNode> getInorder(GenTreeNode root,ArrayList<GenTreeNode> result){
		if(root == null){
			return null;
		}
		else{
			getInorder(root.getLeft_child(),result);
			result.add(root);
			getInorder(root.getRight_child(),result);
			
			return result;
		}
		
		
	}
	
	public ArrayList<GenTreeNode> getPostorder(GenTreeNode root,ArrayList<GenTreeNode> result){
		if(root == null){
			return null;
		}
		else{
			getPostorder(root.getLeft_child(),result);
			getPostorder(root.getRight_child(),result);
			result.add(root);
			
			return result;
		}
		
		
	}

}
