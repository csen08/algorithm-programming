package programming.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DiagonalPrint {
	
	/**
	 * Can be printed in two ways - from left side or right
	 * int [][] grid = new int[][] {
           {1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15, 16}}
           
		Output: 
		Zig-Zag Traversal: 
			1 
			5   2 
			9   6 3 
			13 10 7 4 
			14 11 8 
			15 12 
			16 
	 
	 OR
	 		Zig-Zag Traversal: 
			4 
			3 8 
			2  7 12 
			1  6 11 16 
			5 10 15 
			9 14 
			13
	 * 
	 */

	/**
	 * Output: 
		Zig-Zag Traversal: 
			1 
			5   2 
			9   6 3 
			13 10 7 4 
			14 11 8 
			15 12 
			16 
	 */
	static void zigzag_1(int[][] arr) {
		//go bottom and go right, push them in queue
		//push what? push the values is also fine, or push x+y index is also fine.
		//but queue is must - NO!!
		
		Queue<Integer> q = new LinkedList<>();
		
		//https://algorithms.tutorialhorizon.com/zigzag-or-diagonal-traversal-in-2d-array-matrix-using-queue/
		
		
		int m = arr.length;
		int n = arr[0].length;
		
		//GETTING CONFUSED.. WE DO NOT NEED QUEUE HERE, WE CAN DO IT USING HASHMAP
		//QUEUE IS ANOTHER WAY..
		//KEY OF THE HASHMAP IS (X+Y)
		//VALUE IS AN ARRAYLIST
		//LATER WE WILL LOOP THE ARRAY FROM (0+0) TO (M-1)+(N-1), INCREMENT/ THESE VALUES ARE CONTIGUOUS.
		
		Map<Integer, ArrayList<Integer>> map = new HashMap<>(); //in case we need to diagonal sort, we will use PriorityQueue here instead of ArrayList
		
		//thought came to make key as a string of x_y... but then it will be different. x_y will be different for all cases
		
		for (int j=0;j<n;j++) {
			for (int i=0;i<m;i++) { //loop first on j, i.e. column, then on row.
				map.putIfAbsent(j+i, new ArrayList<>());
				map.get(j+i).add(arr[i][j]);
			}
		}
		
		for (int i=0;i<=m+n-2;i++) {
			System.out.println(map.get(i));
		}
	}
	
	public static void main(String[] args) {
		
		zigzag_1(new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		});
		//x+y - 
		//y-x - reverse zig zag
		
	}
}
