package programming.monotonic;

import java.util.*;

/**
 * 
 * This is reverse approach of max in sub array window
 *
 */
public class Min_value_in_a_sliding_window {
	
	static int[] min_in_subarray_window_k(int[] arr, int k) {
		
		//we need a mono queue which is strictly increasing
		//means push() operation will kick out all elements which are grater than this element
		
		//not creating a separate mono queue, but embedding it in the code
		
		Deque<Integer> q = new LinkedList<>();
		
		for (int i=0; i<arr.length; i++) {
			push(q, arr[i]);
			if (i<k-1)  //when k=3, i=0 ..i=1 ..i=2 ... so we have 3 elements, so go to next block
				continue;
			System.out.println(q.peek()); //start from 2 index
			pop(q, arr[i-k+1]);
		}
		return null;
	}
	
	static void push(Deque<Integer> q, int n) {
		while (!q.isEmpty() && q.peekLast()>n) {
			q.pollLast();
		}
		q.offer(n);
	}
	
	static void pop(Deque<Integer> q, int n) {
		if (!q.isEmpty() && q.peek()==n)
			q.pop();
	}
	
	public static void main(String[] args) {
		
		min_in_subarray_window_k(new int[] {1,2,3,4,5,6,7,8,9},3);
	}

}
