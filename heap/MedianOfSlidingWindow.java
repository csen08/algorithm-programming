package programming.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MedianOfSlidingWindow {

	//https://www.geeksforgeeks.org/median-of-sliding-window-in-an-array/
	
	//few questions, like, if the array is sorted? No
	//challenge https://www.hackerrank.com/challenges/fraudulent-activity-notifications	
	
	//approach is to use two queue
	//window size=k
	
	//solution here, https://wxx5433.gitbooks.io/interview-preparation/content/part_ii_leetcode_lintcode/heap/sliding_window_median.html
	
	public static Double[] sliding_window_median(int[] arr, int k) {
		
		PriorityQueue<Integer> uppers = new PriorityQueue<>(); //min heap, min value is at top
		PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());//max heap, max value is at top
		//Use a max heap to store elements smaller or equal to median, and use a min heap to store elements greater than median.
		//What is median?
		// It it the middle value in a sorted array or list
		//So idea is, to separate the numbers in two groups one will contain bottom half of the numbers and another group will contain top half
		//say, numbers are 1,3,5,8,9,13,15,16, so I will break the numbers in two groups, [1,3,5,8] and [9,13,15,16]
		
		//higher numbers will be in uppers heap, so top will contain the lowest (but grater than median)
		//lower numbers will be in lowers heap, but it is inverted, so top will contain max value, which will be actually the lower than median
		//visually
		//lower:  8(top) 5  3  1
		//upper:  9(top) 13 15 16
		//we work with top element of the heap
		
		List<Double> median_list = new ArrayList<>();
		
		for (int i=0;i<arr.length;i++) {
			
			//1.Add Number
			if (lowers.isEmpty()||arr[i]<=lowers.peek()) //less than or EQUAL, it is possible value is same as the peek
				lowers.offer(arr[i]);
			else
				uppers.offer(arr[i]);
			
			//2.Rebalance
			//(i+1-k) is the index counter that will help to determine the position
			//i starts from 0, and K starts from 1
			if (i+1 > k) {//delete when index exceeds K, index starts at 0, so i+1
				
				//Delete the oldest number
				if (arr[i-k]<=lowers.peek()) {//if oldest is in lowers
					lowers.remove(arr[i-k]);
				}
				else
					uppers.remove(arr[i-k]);
				
			}
			
			//Balancing two heaps
			//---------------------------------------------------
			if (uppers.size()>lowers.size()+1)
				lowers.offer(uppers.poll());
			
			if (lowers.size()>uppers.size()+1)
				uppers.offer(lowers.poll());
			//---------------------------------------------------
			
			
			//3. Calculate median
			//---------------------------------------------------
			if (i+1 >= k) {
				//i starting from 0, and k starting from 1
				//say k=3, when i reaches 2, we start calculating the median
				if (uppers.size()==lowers.size()) {
					double median = (lowers.peek()+uppers.peek())/2.0; //median can be double
					median_list.add(median);
				}
				else {
					double median = uppers.size()>lowers.size()?uppers.peek():lowers.peek();
					median_list.add(median);
				}
			}
			//---------------------------------------------------
			
		}
		
		return median_list.toArray(new Double[median_list.size()]);
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {-1, 5, 13, 8, 2, 3, 3, 1};
		int k=3;
		//Output: 5 8 8 3 3 3
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(sliding_window_median(arr, k)));
		
		System.out.println();
		
		int[] arr2 = {-1, 5, 13, 8, 2, 3, 3, 1};
		int k2 = 4;
		//Output: 6.5 6.5 5.5 3.0 2.5
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(sliding_window_median(arr2, k2)));
		
	}
	
}
