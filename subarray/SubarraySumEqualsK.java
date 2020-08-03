package programming.subarray;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	/**
	 * Problem statement: Given an unsorted array of integers, find the number of 
	 *                    subarrays having sum exactly equal to a given number k.
	 */
	
	static int findSubarraySum(int[] arr, int target) {
		
		Map<Integer, Integer> sum_count = new HashMap<>();
		int res = 0; //counter
		
		int sum_so_far=0; //sum so far from 0th
		
		//Idea: if the difference of two sub-arrays{arr[0-i] and arr[0-j]}(i>j) sum starting from 0 is equals to K,
		// that means there is a sub-array exists {j->i} that sums K
		//We want to find out all such cases
		for (int i=0; i<arr.length;i++) {
			
			sum_so_far+=arr[i];
			
			if (sum_so_far==target) res++; //
			
			if (sum_count.containsKey(sum_so_far-target)) //arr[0-i]-arr[0-j] = K, i.e.arr[0-i]-K = arr[0-j] 
				res+=sum_count.get(sum_so_far-target); //find all such cases
			
//			Integer count = prevSum.get(sumfrombeginning); 
//            if (count == null) 
//                prevSum.put(sumfrombeginning, 1); 
//            else
//                prevSum.put(sumfrombeginning, count+1);  
            
			sum_count.put(sum_so_far, sum_count.getOrDefault(sum_so_far, 0)+1); //put the sum of far in the map
            
            //NOTE:: This problem is similar to 2 sum problem 
		}
		
		return res;
	}
	
	/**
	 * 2 sum problem
	 * Given an array of integers, return the indices of the two numbers whose sum is equal to a given target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * 
	 */
	
	private int[] two_sum_problem(int[] arr, int target) {
		
		int[] res = new int[2];
		
		HashMap<Integer, Integer> map = new HashMap<>(); //map holds the complement value and the index
		
		for (int r=0;r<arr.length;r++) {
			int complement = target-arr[r]; //hold them in variables
			if (map.containsKey(complement)) { //only one solution, so we can return from here safely
				
				res[0]= map.get(target-arr[r]);
				res[1]=r;
				return res;
			}else
			{
				map.put(arr[r], r);
			}
		
			
		}
		return res;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {10, 2, -2, -20, 10};
		int k = -10;
		System.out.println(findSubarraySum(arr, k));
		
		int[] arr2 = {9, 4, 20, 3, 10, 5};
		int k2 = 33;
		System.out.println(findSubarraySum(arr2, k2));
	}
}


