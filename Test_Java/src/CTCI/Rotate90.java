package CTCI;

public class Rotate90 {
	public static void main(String args[]){
		int [][] matrix = new int [4][4];
		int k = 0;
		for(int i=0;i<4;i++){
			for(int j = 0 ;j<4 ;j++){
				matrix[i][j] = k;
				k++;
			}
		}
		for(int i = 0 ;i<4;i++){
			for(int j = 0 ; j<4;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		Rotate90 r90 = new Rotate90();
		matrix = r90.rotate(matrix,4);
	}
	
	public int[][] rotate(int [][] matrix, int n){
		for(int layer = 0; layer<n/2;layer++){
			int first = layer;
			int last = n -1 - layer;
			for(int i = first; i<last;i++){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];///
				matrix[i][last] = top;
			}
		}
		for(int i = 0 ;i<n;i++){
			for(int j = 0 ; j<n;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		return matrix;
	}
}
