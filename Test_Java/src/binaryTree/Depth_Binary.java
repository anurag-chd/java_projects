package binaryTree;

public class Depth_Binary {
	
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
		Depth_Binary dbtree = new Depth_Binary();
		int max_depth = dbtree.calc_depth(btree.root) -1;
		System.out.println("The max depth of binary tree is "+max_depth);
		
	}
	public int calc_depth(TreeNode root){
		if(root == null){
			return 0;
		}
		else{
			return (1+ Math.max(calc_depth(root.getLeft_child()), calc_depth(root.getRight_child())));
		}
		
	}

}
