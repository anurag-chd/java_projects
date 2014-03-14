package CTCI_Recurrsion;

import java.util.ArrayList;

public class RunningStaircase {
	static ArrayList<Integer> ways_list = new ArrayList<Integer>();
	
	public static void main(String args[]){
		int staircase_num = 10;
		//ArrayList<Integer> ways_list = new ArrayList<Integer>();
 		int map[] = new int[staircase_num+1];
		for(int i =0 ;i <staircase_num+1;i++){
			map[i] = -1;
		}
		RunningStaircase rs = new RunningStaircase();
		ways_list.add(0,1);
		int result = rs.getWays(staircase_num,map);
		System.out.println(result);
		System.out.println(ways_list.size());
		for(int i : ways_list){
			System.out.print(" "+i );
		}
	}
	
	public int getWays(int num, int[] map){
		if(num<0){
			
			return 0;
		}
		else if(num == 0){
			return 1;
		}
		else if(map[num] > -1){
			//ways_list.add(num, map[num]);
			return map[num];
		}
		else{
			map[num] = getWays(num-1,map) + getWays(num-2,map) + getWays(num-3,map);
			ways_list.add(num, map[num]);
			return map[num];
		}
	}

}
