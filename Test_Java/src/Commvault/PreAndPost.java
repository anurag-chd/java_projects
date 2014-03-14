package Commvault;

import java.util.ArrayList;

import Basics.*;

public class PreAndPost {
	
	static ArrayList<GenTreeNode> postorder_list = new ArrayList<GenTreeNode>();
	static ArrayList<GenTreeNode> preorder_list = new ArrayList<GenTreeNode>();
	static int pre_index = 0;
    public static void main(String args[]){
		GenTreeNode root = new GenTreeNode('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		//root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode('f'));
		root.getRight_child().setLeft_child(new GenTreeNode('f'));
		root.getRight_child().setRight_child(new GenTreeNode('g'));
		postorder_list = convert_Binary_Postorder(root,postorder_list);
		
		preorder_list = convert_Binary_Preorder(root,preorder_list);
		
		GenTreeNode new_root = getBinaryTree(preorder_list,postorder_list,0,postorder_list.size()-1);
		print_Inorder(root);
		System.out.println("New Tree");
		print_Inorder(new_root);
	}
	
	
	public static  ArrayList<GenTreeNode> convert_Binary_Postorder(GenTreeNode root,ArrayList<GenTreeNode> postorder_list){
		if(root!=null){
			convert_Binary_Postorder(root.getLeft_child(),postorder_list);
			//System.out.println(root.getData());
			
			convert_Binary_Postorder(root.getRight_child(),postorder_list);
			postorder_list.add(root);
			return postorder_list;
		}
		else{
			return null;
		}
		
	}
	
	public static void print_Inorder(GenTreeNode root){
		if(root!=null){
			print_Inorder(root.getLeft_child());
			System.out.println(root.getData());
			
			print_Inorder(root.getRight_child());
		}
		
	}
	
	
	public static ArrayList<GenTreeNode> convert_Binary_Preorder(GenTreeNode root,ArrayList<GenTreeNode> preorder_list){
		if(root!=null){
			preorder_list.add(root);
			//System.out.println(root.getData());
			convert_Binary_Preorder(root.getLeft_child(),preorder_list);
			convert_Binary_Preorder(root.getRight_child(),preorder_list);
			return preorder_list;
		}
		else{
			return null;
		}
	}
	
	
	public static GenTreeNode getBinaryTree(ArrayList<GenTreeNode> preorder_list, ArrayList<GenTreeNode> postorder_list,int start,int end){
		if(start>end){
			return null;
		}
		else{
			if(pre_index == preorder_list.size()){
				return null;
			}
			else{
				GenTreeNode root = preorder_list.get(pre_index);
				pre_index++;
				if(pre_index == preorder_list.size()){
					return null;
				}
				
				int offset = postorder_list.indexOf(preorder_list.get(pre_index));
				if(offset == -1){
					return null;
				}
				else{
					root.setLeft_child(getBinaryTree(preorder_list,postorder_list,start,offset));
					root.setRight_child(getBinaryTree(preorder_list,postorder_list,offset+1,end-1));
					
					return root;
				}
				
			}
			
		}
		
	}

}
