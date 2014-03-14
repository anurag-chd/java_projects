package binaryTree;

public class Mirror_BST {
	
	public static void main(String args[]){
		BinaryST btree = new BinaryST(8);
		btree.insert(6,btree.root);
		btree.insert(10,btree.root);
		btree.insert(5,btree.root);
		btree.insert(7,btree.root);
		btree.insert(9,btree.root);
		btree.insert(11,btree.root);
		btree.printInOrderTree(btree.root);
		System.out.println("Mirror Tree");
		btree.root = mirrorImg(btree.root);
		btree.printInOrderTree(btree.root);
	}
	
	public static TreeNode mirrorImg(TreeNode root){
		if(root == null){
			return null;
		}
		else{
			root.setLeft_child(mirrorImg(root.getLeft_child()));
			root.setRight_child(mirrorImg(root.getRight_child()));
			TreeNode temp ;
			temp = root.getLeft_child();
			root.setLeft_child(root.getRight_child());
			root.setRight_child(temp);
			return root;
		}
	}

}
