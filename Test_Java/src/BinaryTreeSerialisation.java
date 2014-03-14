import java.util.*;
import java.io.*;
public class BinaryTreeSerialisation {
	static GenTreeNode root = new GenTreeNode('a');
	public static void main(String args[]){
		
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode('e'));
		root.getRight_child().setLeft_child(new GenTreeNode('f'));
		BinaryTreeSerialisation btreeserial = new BinaryTreeSerialisation();
		btreeserial.go();
	}
	
	public void go(){
		try{
			File f = new File("SerialTree.txt");
			FileOutputStream fs = new FileOutputStream(f);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			root = tree_modify(root);
			ArrayList<GenTreeNode> bfs_list = convertTreeBfs(root);
			os.writeObject(bfs_list);
			
			os.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public GenTreeNode tree_modify(GenTreeNode root){
		if(root == null){
			return null;
		}
		
		else{
			System.out.println(root.getData());
			
			if(root.getLeft_child() == null && root.getRight_child() != null){
				GenTreeNode leaf_node = new GenTreeNode('#');
				root.setLeft_child(leaf_node);
				//return root;
			}
			
			if(root.getLeft_child() != null && root.getRight_child() == null){
				GenTreeNode leaf_node = new GenTreeNode('#');
				root.setRight_child(leaf_node);
				//return root;
			}
			root.setLeft_child(tree_modify(root.getLeft_child()));
			root.setRight_child(tree_modify(root.getRight_child()));
			
			return root;
			
			
		}
	}
	
	public ArrayList<GenTreeNode> convertTreeBfs(GenTreeNode root){
		ArrayList<GenTreeNode> bfs_list = new ArrayList<GenTreeNode>();
		Queue<GenTreeNode> bfs_queue = new java.util.LinkedList<GenTreeNode>();
		if (root == null)
			return null;
		else{
			bfs_queue.add(root);
			while(!bfs_queue.isEmpty()){
				GenTreeNode temp = bfs_queue.remove();
				bfs_list.add(temp);
				System.out.println(temp.getData());
				if(temp.getLeft_child()!=null){
					bfs_queue.add(temp.getLeft_child());
				}
				if(temp.getRight_child()!=null){
					bfs_queue.add(temp.getRight_child());
				}
			}
			return bfs_list;
			
			
		}
		
		
	}

}
