package CTCI_Recurrsion;
import java.util.*;

public class Subset_Set1 {
	static ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
	public static void main(String args[]){
		ArrayList<Integer> set = new ArrayList<Integer>();
		Collections.addAll(set,1,2);
		Subset_Set1 ss1 = new Subset_Set1();
		allsubsets = ss1.getSets(set,0);
		
		for(ArrayList<Integer> s: allsubsets ){
			Iterator i = s.iterator();
			System.out.print("{");
			while(i.hasNext()){
				System.out.print(i.next()+",");
			}
			System.out.print("}");
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> getSets(ArrayList<Integer> set, int index){
		if(set.size() == index){
			allsubsets.add(new ArrayList<Integer>());// Empty Set
		}
		else{
			allsubsets = getSets(set,index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.addAll(subset);
				list.add(item);
				moresubsets.add(list);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
		
	}
}
