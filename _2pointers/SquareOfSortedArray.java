package programming._2pointers;

import java.util.Arrays;

public class SquareOfSortedArray {
	
	/**
	 * input arr[]={-5,-3,1,4,6}
	 * output = {1,9,16,25,36}
	 * 
	 * Brute force approach is, square them, and sort them.
	 * Both can be done in-place, 
	 * but time complexity would be O(NlogN)
	 * why? O(N) to square them, and O(NlogN) to sort them.
	 * 
	 * we need a way to reduce the time complexity to O(N)
	 * We will get space complexity of O(N) in that case
	 */
	
	public static int[] sorted_square(int[] arr) {
		
		int[] result = new int[arr.length];
		int front=0;
		int end=arr.length-1;
		int idx = end; // that will keep calculation of result array
		
		while(front <= end) {//or idx>=0
			if (Math.abs(arr[front]) < Math.abs(arr[end])) {
				result[idx]=arr[end]*arr[end];
				end--;
				idx--;
			}
			else {
				result[idx]=arr[front]*arr[front];
				front++;
				idx--;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {-5,-3,1,4,6};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sorted_square(arr)));
		
	}
}
