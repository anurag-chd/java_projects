package Basics;
import java.io.*;
import java.util.*;

public class BinaryTreeDeserialisation {
	
	public static void main(String args[]){
		BinaryTreeDeserialisation btreedeserial = new BinaryTreeDeserialisation();
		btreedeserial.go();
	}
	
	public void go(){
		try{
			File f = new File("SerialTree.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<GenTreeNode> btree_list= (ArrayList<GenTreeNode>)ois.readObject();
		//	GenTreeNode[] btree_arr = (GenTreeNode[])btree_list.toArray();
			GenTreeNode root = convert_Btree(btree_list);
			btree_print(root);
		//	System.out.println(btree_list.get(0).getData());
			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public GenTreeNode convert_Btree(ArrayList<GenTreeNode> btree_list){
		int index;
		
		for(index = 0 ;index <=(btree_list.size()/2);index++){
			if((2*index+1)<btree_list.size()){
				if(btree_list.get((2*index)+1).getData().equals('#')){
					btree_list.get(index).setLeft_child(null);
				}
				else{
					btree_list.get(index).setLeft_child(btree_list.get((2*index)+1));
				}
				if(btree_list.get((2*index)+2).getData().equals('#')){
					btree_list.get(index).setRight_child(null);
				}
				else{
					btree_list.get(index).setRight_child(btree_list.get((2*index)+2));
				}
			}
			
		}
		GenTreeNode root = btree_list.get(0);
		return root;
	}
	

	public void btree_print(GenTreeNode root){
		if(root!=null){
			System.out.println(root.getData());
			btree_print(root.getLeft_child());
			btree_print(root.getRight_child());
		}
	}
}
