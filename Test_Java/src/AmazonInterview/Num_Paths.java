package AmazonInterview;

public class Num_Paths {
	public static void main(String args[]){
		int row = 3 , col = 3;
		findpaths(row,col);
	}
	
	public static void findpaths(int row, int col){
		int path_arr[][] = new int [row][col];
		for(int i = 0; i<row;i++){
			for(int j = 0; j<col;j++){
				path_arr[i][j] = 0;
			}
		}
		for(int i = 0; i<row;i++){
			for(int j = 0; j<col;j++){
				if(i==0 || j == 0)
					path_arr[i][j] = 1;
				else
					path_arr[i][j] = path_arr[i-1][j] + path_arr[i][j-1];
			}
		}
		System.out.println(path_arr[row-1][col-1]);

	}
}
