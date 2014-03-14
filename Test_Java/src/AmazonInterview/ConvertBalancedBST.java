package AmazonInterview;

import binaryTree.*;

public class ConvertBalancedBST {
	public static void main(String args[]){
		BinaryST btree = new BinaryST();
		for(int i = 5 ; i>=1 ;i--){
			btree.root = btree.insert(i, btree.root);
		}
		System.out.println(btree.root.getData());
		
		if(btree.root.getLeft_child() == null)
			btree.root = convertBST(btree.root,true);
		
		else
			btree.root =convertBST(btree.root,false);
		//btree.printPreOrderTree(btree.root);
		System.out.println(btree.root.getData());
	}
	
	public static TreeNode convertBST(TreeNode root,boolean asc){
		if(root == null){
			return null;
		}
		else{
			if(isBalanced(root)){
				return root;
			}
			else{
				if(asc){
					TreeNode temp = root;
					temp = temp.getRight_child();
					while(temp.getLeft_child()!=null){
						temp = temp.getLeft_child();
					}
					temp.setLeft_child(root);
					if(temp != root.getRight_child()){
						temp.setRight_child(root.getRight_child());
					}
					root.setRight_child(null);
					
					root = temp;
					//System.out.println(root.getLeft_child().getData());
					//System.out.println(root.getRight_child().getData());
					//System.out.println(root.getData());
					
					return convertBST(root, true);
				}
				else{
					TreeNode temp = root;
					temp = temp.getLeft_child();
					while(temp.getRight_child()!=null){
						temp = temp.getRight_child();
					}
					temp.setRight_child(root);
					if(temp != root.getLeft_child()){
						temp.setLeft_child(root.getLeft_child());
					}
					root.setLeft_child(null);
					root = temp;
					return convertBST(root, false);
					
				}
			}
		}
	}
	
	public static boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		else{
			//System.out.println(maxHeight(root));
			//sSystem.out.println(minHeight(root));
			if(Math.abs(maxRightHeight(root)- maxLeftHeight(root)) <=1){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public static int maxLeftHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			//System.out.println(1 +Math.max(maxHeight(root.getLeft_child()), maxHeight(root.getRight_child() ) ) );
			return (1 + maxLeftHeight(root.getLeft_child() ) ) ;
		}
	}
	
	public static int maxRightHeight(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return (1 +maxRightHeight(root.getRight_child() ));
		}
	}
	
	
}