package CTCI_Recurrsion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Subset_SetBit {

	public static void main(String args[]){
		int set[] = {1,2,3};
		
		Subset_SetBit ssb = new Subset_SetBit();
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		
		allsubsets=ssb.getSubSet(set);
		
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
	
	public ArrayList<ArrayList<Integer>> getSubSet(int set[]){
		int n = set.length;
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<(1<<n);i++){
			ArrayList<Integer> subsets = new ArrayList<Integer>();
			for(int k = 0;k<n;k++){
				if(( i &(1<<k) ) > 0){
					subsets.add(set[k]);
				}
			}
			allsubsets.add(subsets);
			
		}
		return allsubsets;
	}
	
	
	
}

