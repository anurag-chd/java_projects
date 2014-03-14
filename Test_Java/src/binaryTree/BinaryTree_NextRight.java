package binaryTree;

import java.util.*;

public class BinaryTree_NextRight {
	r_node root;
	public static void main(String args[]){
		BinaryTree_NextRight btree = new BinaryTree_NextRight();
		btree.root = new r_node('A');
		btree.root.setRight(new r_node('C'));
		btree.root.setLeft(new r_node('B'));
		btree.root.getLeft().setLeft(new r_node('D'));
		btree.root.getLeft().setRight(new r_node('E'));
		btree.root.getRight().setRight(new r_node('F'));
		btree.root = btree.tree_modify(btree.root);
		ArrayList<r_node> bfs_list = new ArrayList<r_node>();
		bfs_list = btree.convertTreeBfs(btree.root);
		Iterator<r_node> it = bfs_list.iterator();
		while(it.hasNext()){
			System.out.print(it.next().getData()+" ");
		}
		r_node new_root = btree.convert_Btree(bfs_list);
		System.out.println(" ");
		System.out.println(new_root.getNextRight());
		System.out.println(new_root.getLeft().getNextRight().getData());
		
		System.out.println(new_root.getLeft().getNextRight().getNextRight());
		System.out.println(new_root.getLeft().getLeft());
		System.out.println(new_root.getLeft().getLeft().getNextRight());
		System.out.println(new_root.getLeft().getLeft().getNextRight().getNextRight());
	}
	
	public r_node tree_modify(r_node root){
		if(root == null){
			return null;
		}
		
		else{
			//System.out.println(root.getData());
			
			if(root.getLeft() == null && root.getRight() != null){
				r_node leaf_node = new r_node('#');
				root.setLeft(leaf_node);
				//return root;
			}
			
			if(root.getLeft() != null && root.getRight() == null){
				r_node leaf_node = new r_node('#');
				root.setRight(leaf_node);
				//return root;
			}
			root.setLeft(tree_modify(root.getLeft()));
			root.setRight(tree_modify(root.getRight()));
			
			return root;
			
			
		}
	}
	
	
	public ArrayList<r_node> convertTreeBfs(r_node root){
		ArrayList<r_node> bfs_list = new ArrayList<r_node>();
		Queue<r_node> bfs_queue = new java.util.LinkedList<r_node>();
		if (root == null)
			return null;
		else{
			bfs_queue.add(root);
			while(!bfs_queue.isEmpty()){
				r_node temp = bfs_queue.remove();
				bfs_list.add(temp);
				if(temp.getLeft()!=null){
					bfs_queue.add(temp.getLeft());
				}
				if(temp.getRight()!=null){
					bfs_queue.add(temp.getRight());
				}
			}
			return bfs_list;
			
			
		}
	}
	
	public r_node convert_Btree(ArrayList<r_node> btree_list){
		int index;
		int index_pow= 1;
		for(index =1 ; index < btree_list.size() ; index++){
			if(index > Math.pow(2,(index_pow))){
				index_pow++;
			}
			if((2*(Math.pow(2,(index_pow-1))-1)) < index && index < (2*(Math.pow(2,index_pow)-1)) ){
					if(btree_list.get(index).getData() == '#'){
						
					}
					else{
						if(btree_list.get(index+1).getData() == '#' && (index+2 <= (2*(Math.pow(2,index_pow)-1)))){
							btree_list.get(index).setNextRight(btree_list.get(index+2));
						}
						
						else{
							btree_list.get(index).setNextRight(btree_list.get(index+1));
						}
					}
			}
		}
		
		for(index = 0 ;index <=(btree_list.size()/2);index++){
			
			
			
			if((2*index+1)<btree_list.size()){
				
					if(btree_list.get((2*index)+1).getData() == ('#')){
						btree_list.get(index).setLeft(null);
					}
					else{
						btree_list.get(index).setLeft(btree_list.get((2*index)+1));
					}
					if(btree_list.get((2*index)+2).getData() == ('#')){
						btree_list.get(index).setRight(null);
					}
					else{
						btree_list.get(index).setRight(btree_list.get((2*index)+2));
					}
				
				
				
			}
			
		}
		r_node root = btree_list.get(0);
		return root;
	}
}	

class r_node{
	char data;
	r_node left;
	r_node right;
	r_node nextRight;
	
	public r_node(char data){
		this.data = data;
	}
	
	public String toString(){
		String str = Character.toString(this.getData());
		return str;
	}
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public r_node getLeft() {
		return left;
	}
	public void setLeft(r_node left) {
		this.left = left;
	}
	public r_node getRight() {
		return right;
	}
	public void setRight(r_node right) {
		this.right = right;
	}
	public r_node getNextRight() {
		return nextRight;
	}
	public void setNextRight(r_node nextRight) {
		this.nextRight = nextRight;
	}
	
	
}
