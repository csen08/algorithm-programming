package programming.matrix;

import java.util.Arrays;

public class Transpose {
	
	/**
	 * int[][] myArray = { 
	 * 	{0, 1, 2, 3}, 
	 * 	{4, 5, 6, 7}, 
	 * 	{8, 9, 10,11}, 
	 * 	{12,13,14,15}};
	 * 
	 *   we need to transpose it with in-space complexity
	 *   transpose of a matrix where row becomes column and column becomes row
	 *   
	 *  So, transpose of above matrix is,
	 *  {0, 4, 8, 12}
	 *  {1, 5, 9, 13}
	 *  {2, 6, 10,14}
	 *  {3, 7, 11,15}}; 
	 *   
	 */

	public static void transpose(int[][] arr) {
		// In this case we will create a new matrix and populate it with
		// a loop on original matrix
		
		System.out.println("Matrix is");
		print(arr);
		int t_col= arr.length;
		int t_row=arr[0].length;
		
		int[][] transpose = new int[t_row][t_col];
		
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				transpose[j][i]=arr[i][j];
			}
		}
		System.out.println("After transpose");
		print(transpose);
	}
	
	public static void transpose_in_place(int[][] arr) {
	
		System.out.println("Matrix is");
		print(arr);
		// First, it has to be a square matrix, otherwise in-space cannot be done
		// Note that, for a N dimensional matrix, elements are not transposed
		// at [i][i] indexes
		// we need to swap values around it at each row
		
		/*
		 *  00 01 02 03
		 *  10 11 12 13
		 *  20 21 22 23
		 *  30 31 32 33
		 */
		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				int t=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=t;
			}
		}
		
		System.out.println("Transpose in-space");
		print(arr);
	}
	
	public static void print(int[][] arr) {
		
		for (int i=0; i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	public static void main(String[] args) {
		
		 int[][] myArray = { 
				 {0, 1, 2, 3}, 
				 {4, 5, 6, 7}, 
				 {8, 9, 10,11}, 
				 {12,13,14,15}};
		 
		 transpose(myArray);
		 System.out.println();
		 transpose_in_place(myArray);
		 
	}
	
}
