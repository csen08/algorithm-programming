package programming.subarray;

/**
 * Sum of all sub arrays
 * Notice here, we are saying, sub-array and not sub-set
 * So an array {1,2,3} will have subarrays {1},{2},{3},{1,2},{2,3},{1,2,3}
 * {1,3} is NOT a sub-array, but it is a subset
 */

public class SubarraySumOfAll {

	
	//1. Approach 1: O(n^2), sum of all sub arrays
	
	public static int sum_of_all_subarrays_o_of_n_square(int[] arr) {
		
		int res=0;
		
		for (int i=0;i<arr.length;i++) {
			
			int sum=0;
			for (int j=i;j<arr.length;j++) { // NOTE: j init with i
				//if the array is [1,2,3], 
				//1st iteration: inner loop with find subarray [1],[1,2],[1,2,3]
				//2nd iteration: [2],[2,3]
				//3rd iteration: [3]
				sum+=arr[j];
				
				res+=sum;
			}
		}
		
		return res;
	}
	
	//2. Approach 2: O(n)
	// Explanation is in GFG, https://www.geeksforgeeks.org/sum-of-all-subarrays/
	//For GFG,
	//for ith element, i appears as beginning element of a sub-array, (n-i) times
	//and i appears at other position of a subarray i*(n-i) times
	//total ith element appears (n-i)+i*(n-i) = (n-i)(1+i) times
	//this is the formula
	
	public static int sum_of_all_subarrays_o_of_n(int[] arr) {
		
		int res=0;
		int n = arr.length;
		for (int k=0;k<n;k++) {
			res+= (n-k)*(1+k)*arr[k];
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr1= {1,2,3};
		System.out.println(sum_of_all_subarrays_o_of_n_square(arr1));
		System.out.println(sum_of_all_subarrays_o_of_n(arr1));
	}
	
}
