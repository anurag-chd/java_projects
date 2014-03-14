package PracticeQues;
import java.util.*;
public class Pre_In_Binary {
	 
	 ArrayList<GenTreeNode> inorder_list = new ArrayList<GenTreeNode>();
	 ArrayList<GenTreeNode> preorder_list = new ArrayList<GenTreeNode>();
	public static void main(String args[]){
		Pre_In_Binary prein_bin = new Pre_In_Binary();
		 ArrayList<GenTreeNode> inorder_list = new ArrayList<GenTreeNode>();
		 ArrayList<GenTreeNode> preorder_list = new ArrayList<GenTreeNode>();
		GenTreeNode root = new GenTreeNode('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode('e'));
		root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode('f'));
		root.getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getRight_child().setRight_child(new GenTreeNode('h'));
		inorder_list = prein_bin.convert_Binary_Inorder(root,inorder_list);
		
		preorder_list = prein_bin.convert_Binary_Preorder(root,preorder_list);
		
		for(GenTreeNode node:inorder_list){
			System.out.println(node.getData());
		}
		System.out.println();
		for(GenTreeNode node:preorder_list){
			System.out.println(node.getData());
		}
		
		GenTreeNode new_root = prein_bin.convert_Binary(inorder_list,preorder_list,0,inorder_list.size()-1,0,preorder_list.size()-1);
		System.out.println("NEw Tree");
		
		prein_bin.print_Inorder(new_root);
		//System.out.println(new_root.getData());
		//System.out.println(new_root.getRight_child().getData());
	}
	
	public ArrayList<GenTreeNode> convert_Binary_Inorder(GenTreeNode root,ArrayList<GenTreeNode> inorder_list){
		if(root!=null){
			convert_Binary_Inorder(root.getLeft_child(),inorder_list);
			//System.out.println(root.getData());
			inorder_list.add(root);
			convert_Binary_Inorder(root.getRight_child(),inorder_list);
			return inorder_list;
		}
		else{
			return null;
		}
		
	}
	
	public void print_Inorder(GenTreeNode root){
		if(root!=null){
			print_Inorder(root.getLeft_child());
			System.out.println(root.getData());
			
			print_Inorder(root.getRight_child());
		}
		
	}
	public ArrayList<GenTreeNode> convert_Binary_Preorder(GenTreeNode root,ArrayList<GenTreeNode> preorder_list){
		if(root!=null){
			preorder_list.add(root);
			//System.out.println(root.getData());
			convert_Binary_Preorder(root.getLeft_child(),preorder_list);
			convert_Binary_Preorder(root.getRight_child(),preorder_list);
			return preorder_list;
		}
		else{
			return null;
		}
	}
	
	public GenTreeNode convert_Binary(ArrayList<GenTreeNode> inorder_list,ArrayList<GenTreeNode> preorder_list,int startin,int endin,int startpre, int endpre ){
		if(startin>endin || startpre > endpre){
			return null;
		}
		else{
			GenTreeNode root = preorder_list.get(startpre);
			int offset = inorder_list.indexOf(root);
			if(offset == -1){
				return null;
			}
			{
				root.setLeft_child(convert_Binary(inorder_list,preorder_list,startin,offset-1,startpre+1,offset+ startpre));
				root.setRight_child(convert_Binary(inorder_list,preorder_list,offset+1,endin,offset+1+startpre-startin,endpre));
			
			}
			return root;
			
		}
		/*if(inorder_list.size() == 1 && preorder_list.size() == 1){
			GenTreeNode root= preorder_list.get(0);
			return null;
		}
		if(inorder_list.size()>1 && preorder_list.size() >1){
			GenTreeNode root= preorder_list.get(0);
			int index = inorder_list.indexOf(root);
			root.setLeft_child(preorder_list.get(1));
			int right_child_index = preorder_list.indexOf(inorder_list.get(index-1)) +2;
			root.setRight_child(preorder_list.get(right_child_index));
			ArrayList<GenTreeNode> left_inorder_list= new ArrayList<GenTreeNode>();
			ArrayList<GenTreeNode> left_preorder_list= new ArrayList<GenTreeNode>();
			ArrayList<GenTreeNode> right_inorder_list= new ArrayList<GenTreeNode>();
			ArrayList<GenTreeNode> right_preorder_list= new ArrayList<GenTreeNode>();
			
			
			
			for(int i = 0; i<index;i++){
				System.out.println("left_InorderList "+inorder_list.get(i).getData()+" "+i);
				left_inorder_list.add(inorder_list.get(i));
			}
			for(int i = (index+1);i < inorder_list.size();i++){
				System.out.println("Right_InorderList "+inorder_list.get(i).getData()+" "+i);
				right_inorder_list.add(inorder_list.get(i));
			}
			for(int i = 1; i<right_child_index;i++){
				System.out.println("left_PreorderList "+preorder_list.get(i).getData()+" "+i);
				left_preorder_list.add(preorder_list.get(i));
			}
			for(int i = right_child_index; i<preorder_list.size();i++){
				System.out.println("Right_PreorderList "+preorder_list.get(i).getData()+" "+i);
				right_preorder_list.add(preorder_list.get(i));
			}
			//root.setLeft_child(convert_Binary(left_inorder_list,left_preorder_list));
			//root.setRight_child(convert_Binary(right_inorder_list,right_preorder_list));
			convert_Binary(left_inorder_list,left_preorder_list);
			convert_Binary(right_inorder_list,right_preorder_list);
			return root;
		}
		else {
			return null;
		}*/
	}
	

}


