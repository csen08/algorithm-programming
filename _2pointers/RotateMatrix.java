package programming._2pointers;

public class RotateMatrix {
	// rotate a matrix by 90 degree clockwise
	// rotate with constant space
	/**
			1 2 3 
			4 5 6
			7 8 9  
			Output:
			7 4 1 
			8 5 2
			9 6 3
			
			Input:
			1 2
			3 4
			Output:
			3 1
			4 2 
			
			Output:
			1 2 3 4 
			5 6 7 8 
			9 10 11 12 
			13 14 15 16 
			Output:
			13 9 5 1 
			14 10 6 2 
			15 11 7 3 
			16 12 8 4 

	 */
	
	public static void main(String[] args) {
		
		int[][] matrix1 = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Input:");
		print(matrix1);
		rotate(matrix1);
		System.out.println("-------------------");
		
		int[][] matrix2 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("Input:");
		print(matrix2);
		rotate(matrix2);
		System.out.println("-------------------");
		
	}
	
	static void rotate(int[][] matrix) {
		
		int N = matrix.length;
		
		// Step 1: Transpose of this matrix - done by swap diagonally
		for (int i=0;i<N;i++) { // this is row
			for (int j=i;j<N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i]= temp;
			}
		}
		
		//2. now swap ends using two pointer approach
		for (int i=0;i<N;i++) {
			for (int j=0; j<N/2 ; j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N-1-j];
				matrix[i][N-1-j]= temp;
			}
		}
		System.out.println("Output:");
		print(matrix);
	}
	
	static void print (int[][] matrix) {
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
