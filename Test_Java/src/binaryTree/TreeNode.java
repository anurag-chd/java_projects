package binaryTree;




public class TreeNode {

	private int data;
	private TreeNode left_child;
	private TreeNode right_child;
	
	public TreeNode(int num){
		this.data = num;
	}
		
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft_child() {
		return left_child;
	}

	public void setLeft_child(TreeNode left_child) {
		this.left_child = left_child;
	}

	public TreeNode getRight_child() {
		return right_child;
	}

	public void setRight_child(TreeNode right_child) {
		this.right_child = right_child;
	}

	
	
}
