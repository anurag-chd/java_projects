package CTCI_Recurrsion;

public class Eight_Queen {
	public static void main(String args[]){
		int no_queen = 8;
		showPosition(no_queen);
		
	}
	
	public static void showPosition(int num){
		int arr[][] = new int[num][num];
		for(int i = 0 ; i< num ;i++){
			for(int j= 0; j<num;j++){
				arr[i][j] = 0;
			}
		}
		if(solve(arr,0)){
			System.out.println("Solution exist");
			printArray(arr);
		}
		else{
			System.out.println("Solution not exist");
		}
		
		
	}
	
	static void printArray(int arr[][]){
		int len = arr[0].length;
		for(int i = 0; i< len ;i++){
			for(int j =0 ; j< len ;j++){
				System.out.print(arr[i][j]+", ");
			}
			System.out.println();
		}
	}
	
	public static boolean solve(int arr[][], int column){
		int no_rows = arr[0].length;
		if(column >= no_rows){
			return true;
		}
		
		for(int i = 0; i<no_rows;i++){
			if(safePos(arr,i,column)){
				arr[i][column] =1;
				if(solve(arr,column+1)){
					return true;
				}
				arr[i][column] =0;
			}
		}
		
		return false;
	}
	
	public static boolean safePos(int arr[][], int row,int column){
		
		/// checking row from left
		for(int i =0;i<column;i++){
			if(arr[row][i] ==1){
				return false;
			}
		}
		
		/// checking the diagonal on left top
		for(int i = row, j = column;i>=0  && j>=0;i--,j--){
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		/// checking the diagonal on left bottom
		for(int i = row, j = column;i<arr[0].length  && j>=0;i++,j--){
			if(arr[i][j] == 1){
				return false;
			}
		}
		
		return true;
	}

}
