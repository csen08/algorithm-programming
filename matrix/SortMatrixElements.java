package programming.matrix;

import java.util.Arrays;

public class SortMatrixElements {

	/**
	 * What is sorted matrix?
	 * 
	 * It is a 2-D array where rows and columns are sorted in some order (ascending or descending)
	 * 
	 */	
	//https://www.geeksforgeeks.org/sort-the-given-matrix-memory-efficient-approach
	// we need to visualize the 2-D array as  1-D array where,- 
	//i TH Element of the Matrix = Mat[ i / cols ][ i % cols ] - IMPORTANT
	
	//That means,
	//0th element(in an array) position is=mat[0/N][0%N]=MAT[0][0]
	//1th element(in an array) position is=mat[1/N][1%N]=MAT[0][1]
	//N-1 th element position is=mat[N-1/N][N-1%N]
	//Nth element position is=mat[N/N][N%N]=mat[1][0]
	
	// So after we 'flatten' the 2-D array to 1-D array, we sort it in-place.
	
	// We will use bubble sort, which has complexity of O(N*2)
	//Bubble sort has space complexity of O(1), i.e. in-space complexity
	//so this code runs without extra space
	
	public static void sort_a_matrix(int[][] arr) {
		
		int row = arr.length;
		int col = arr[0].length;
		
		int total_elements=row*col; // we need this count, as bubble sort runs on the total elements
		
		for (int i=0;i <total_elements-1; i++) { // Simple bubble sort here, where out loop runs N-1 times
			
			for (int j=0;j<total_elements -1 -i; j++) { // And inner loop runs (N-1-i) times, because the right end elements start getting their correct position
				                                        // But surely does NOT reduce the overall time complexity
				                                        // If in doubt, check it with a small array during interview      
				
				if (arr[j/col][j%col]>arr[(j+1)/col][(j+1)%col]) {
					
					//swap code
					int t = arr[j/col][j%col];
					arr[j/col][j%col] = arr[(j+1)/col][(j+1)%col];
					arr[(j+1)/col][(j+1)%col] = t;
				}
				
			}
			
		}
		
		System.out.println("After sort");
		print(arr);
		
	}
	
	public static void swap(int i,int j) {
		
		int t = i;
		i=j;
		j=t;
	}
	
	public static void print(int[][] arr) {
		
		for (int i=0; i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void main(String[] args) {
		
		
		 int[][] myArray = { 
				 {5, 4, 7}, 
				 {1, 3, 8}, 
				 {2, 9, 6}};
		
		 System.out.println("Matrix is");
		 print(myArray);
		 System.out.println();
		 sort_a_matrix(myArray);
	}
	
}
