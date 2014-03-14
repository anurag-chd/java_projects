import java.util.*;
public class DfsBinary {
	static GenTreeNode root = new GenTreeNode('a');
	public static void main(String args[]){
		DfsBinary dfs = new DfsBinary();
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode('e'));
		root.getRight_child().setLeft_child(new GenTreeNode('f'));
		dfs.dfsTraverse(root);
	}
	
	public void dfsTraverse(GenTreeNode root){
		Stack <GenTreeNode> stack = new Stack<GenTreeNode>();
		stack.push(root);
		while(!stack.empty()){
			GenTreeNode temp = stack.pop();
			System.out.println(temp.getData());
			
			if(temp.getRight_child()!=null){
				stack.push(temp.getRight_child());
			}
			if(temp.getLeft_child()!=null){
				stack.push(temp.getLeft_child());
			}
		}
		 
		
	}
	
}
