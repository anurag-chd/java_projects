package Basics;

public class BinaryST {
	public TreeNode root ;
	
	public BinaryST(){
		root = null;
	}
	
	public BinaryST(int num){
		root = new TreeNode(num);
		
	}

	
	public TreeNode insert(int data, TreeNode root){
		TreeNode t = new TreeNode(data); 
		//TreeNode temp = this.root;
		if (root == null){
			root = t;
			return root;
		}
		else{
			if(data<=root.getData()){
				root.setLeft_child(insert(data,root.getLeft_child()));
				return root;
			}
			else{
				root.setRight_child(insert(data,root.getRight_child()));
				return root;
			}
			
		}
	}
	
	public TreeNode delete(int data, TreeNode root){
		if(root == null){
			return null;
		}
		else{
			if(root.getData() == data){
				if(root.getLeft_child() == null && root.getRight_child() == null){
					root = null;
					return root;
				}
				else if(root.getLeft_child() == null && root.getRight_child() != null){
					root  = getRight_LeftMost(root);
					return root;
					
				}
				else{
					root = getLeft_RightMost(root);
					return root;
				}
				
				
				
			}
			if(root.getData() > data){
				root.setLeft_child(delete(data,root.getLeft_child()));
				return root;
			}
			else{
				root.setRight_child(delete(data,root.getRight_child()));
				return root;
			}
			
			
		}
	}
	
	public TreeNode getLeft_RightMost(TreeNode tn){
		TreeNode first_left = tn.getLeft_child();
		if(first_left.getRight_child() == null){
			first_left.setRight_child(tn.getRight_child());
			return first_left;
		}
		else{
			TreeNode parent = first_left;
			TreeNode child = first_left.getRight_child();
			while(child.getRight_child() != null){
				parent = child;
				child = child.getRight_child();
			}
			parent.setRight_child(child.getLeft_child());
			child.setLeft_child(tn.getLeft_child());
			child.setRight_child(tn.getRight_child());
			return child;
			
			//while(first_right.getLeft_child())
		}
		
	}
	
	public TreeNode getRight_LeftMost(TreeNode tn){
		TreeNode first_right = tn.getRight_child();
		if(first_right.getLeft_child() == null){
			first_right.setLeft_child(tn.getLeft_child());
			return first_right;
		}
		else{
			TreeNode parent = first_right;
			TreeNode child = first_right.getLeft_child();
			while(child.getLeft_child() != null){
				parent = child;
				child = child.getLeft_child();
			}
			parent.setLeft_child(child.getRight_child());
			child.setLeft_child(tn.getLeft_child());
			child.setRight_child(tn.getRight_child());
			return child;
			
			//while(first_right.getLeft_child())
		}
		
	}
	
	public void printInOrderTree(TreeNode tn){
		/*if(tn == null){
			System.out.println("Tree has no elements");
		}*/
		if(tn!=null){
			printInOrderTree(tn.getLeft_child());
			System.out.println(tn.getData());
			printInOrderTree(tn.getRight_child());
			
		}
	}
	
	public void printPreOrderTree(TreeNode tn){
		/*if(tn == null){
			System.out.println("Tree has no elements");
		}*/
		if(tn!=null){
			System.out.println(tn.getData());
			printPreOrderTree(tn.getLeft_child());
			printPreOrderTree(tn.getRight_child());
			
		}
	}
	
	public void printPostOrderTree(TreeNode tn){
		/*if(tn == null){
			System.out.println("Tree has no elements");
		}*/
		if(tn!=null){
			printPostOrderTree(tn.getRight_child());
			System.out.println(tn.getData());
			printPostOrderTree(tn.getLeft_child());
			
			
			
		}
	}
	
}
