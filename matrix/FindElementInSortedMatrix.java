package programming.matrix;

public class FindElementInSortedMatrix {
	
	/**
	 * What is sorted matrix?
	 * 
	 * It is a 2-D array where rows and columns are sorted in some order (ascending or descending)
	 * 
	 */
	// https://www.youtube.com/watch?v=dsPdwhRR_84
	// we will use the sorted property here,
	//Starting from top-right => If grater, then go down, if smaller, then go left. We will NEVER GO UP or RIGHT.
	// Or bottom-left => UP and RIGHT, but NEVER DOWN and LEFT
	// So we will run a loop
	// And what is the breaking condition of this loop?  indexes should never become zero or row/column size
	
	
	public static void find_element_down_left(int[][] arr, int key) {
		
		int row=0, col=arr[0].length-1; // TOP-RIGHT corner
		while (row<arr.length && col>=0) { // so this loop can go till that point, if not found, return false
			
			if (arr[row][col]==key) {
				System.out.println("Key "+key+" found at "+"["+row+","+col+"].");
				return;
			}
			else {
				if (key < arr[row][col])
					col--;
				else
					row++;
			}
		}
		System.out.println("Key "+key+" not found.");
	}
	
	
	public static void find_element_up_right(int[][] arr, int key) {
		
		int row = arr.length-1;
		int col = 0;
		
		while (row >=0 && col<arr[0].length) {
			
			if (key == arr[row][col]) {
				System.out.println("Key "+key+" found at "+"["+row+","+col+"].");
				return;
			}
			else {
				if (key < arr[row][col])
					row--;
				else
					col++;
			}
		}
		System.out.println("Key "+key+" not found.");
	}
	
	public static void main(String[] args) {
		
		int[][] mat = 
			{
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}};
		
		find_element_up_right(mat, 20);
		find_element_up_right(mat, 36);
		System.out.println();
		find_element_down_left(mat, 29);
		find_element_down_left(mat, 40);
	}
	
	
}
