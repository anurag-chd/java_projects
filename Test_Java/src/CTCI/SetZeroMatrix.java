package CTCI;

public class SetZeroMatrix {

	public static void main(String args[]){
		int matrix[][] = new int[4][4];
		for(int i = 0; i<matrix.length;i++){
			for(int j = 0; j<matrix[0].length; j++){
				matrix[i][j]=1;
			}
		}
		matrix[0][3] = 0;
		matrix[3][1] = 0;
		
		SetZeroMatrix szm = new SetZeroMatrix();
		szm.replace(matrix);
	}
	
	public void replace(int matrix[][]){
		int row[] = new int[matrix.length];
		int col[] = new int[matrix[0].length];
		for(int i = 0; i<matrix.length;i++){
			for(int j = 0; j<matrix[0].length; j++){
				if(matrix[i][j]==0){
					row[i]=1;
					col[j]=1;
				}
			}
		}
		
		for(int i = 0; i<matrix.length;i++){
			for(int j = 0; j<matrix[0].length; j++){
				if(row[i] == 1 || col[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i<matrix.length;i++){
			for(int j = 0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
