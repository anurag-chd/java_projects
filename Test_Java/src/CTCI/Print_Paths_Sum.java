package CTCI;

import Basics.GenTreeNode;
import java.util.*;
public class Print_Paths_Sum {

	public static void main(String args[]){
		GenTreeNode<Integer> root1 = new GenTreeNode<Integer>(1);
		root1.setLeft_child(new GenTreeNode<Integer>(2));
		root1.setRight_child(new GenTreeNode<Integer>(3));
		root1.getLeft_child().setLeft_child(new GenTreeNode<Integer>(3));
		root1.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode<Integer>(4));
		root1.getRight_child().setLeft_child(new GenTreeNode<Integer>(6));
		root1.getLeft_child().setRight_child(new GenTreeNode<Integer>(7));
		
		Print_Paths_Sum pps = new Print_Paths_Sum();
		ArrayList<Integer> list = new ArrayList<Integer>();
		pps.findSum(root1,list,10,0);
	}
	
	public void findSum(GenTreeNode root1, ArrayList<Integer> list, int sum, int level){
		if(root1 == null) {
			return;
		}
		//else{
			int temp = sum;
			list.add((int)root1.getData());
			for(int i =level;i>-1;i--){
				temp = temp - list.get(i);
				if(temp == 0)
					printList(list,i,level);
			}
			
			ArrayList<Integer> c1 = (ArrayList<Integer>)list.clone();
			ArrayList<Integer> c2 = (ArrayList<Integer>)list.clone();
			
			findSum(root1.getLeft_child(),c1,sum,level+1);
			findSum(root1.getRight_child(),c2,sum,level+1);
			
		//}
	}
	
	public void printList(ArrayList<Integer> list, int level, int limit){
		for(int i= level ; i<=limit; i++){
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
	}
	
	
}
