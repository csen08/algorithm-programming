package programming.monotonic;

import java.util.*;

public class MonotonicStack {

	
	static int[] nextGreaterElement(int[] nums) {
	    int[] ans = new int[nums.length]; // array to store answer
	    Stack<Integer> s = new Stack<>();
	    for (int i = nums.length - 1; i >= 0; i--) { // put it into the stack back to front
	        while (!s.empty() && s.peek() <= nums[i]) { // determine by height
	            s.pop(); // short one go away while blocked
	        }
	        ans[i] = s.empty() ? -1 : s.peek(); // the first tall behind this element
	        s.push(nums[i]); // get into the queue and wait for later height determination
	    }
	    System.out.println(Arrays.toString(ans));
	    return ans;
	    
	    //for (i=n-1 to 0, i--) {
	    	//if stack is empty, res[i]=-1, and s.push(num[i]);
	    	//else {
	    	//		~kick out all while s.peek()< num[i]//heavy will fall down
	    	//		s.pop
	    	//		after the kick out, what will remain is the 
	    //}
	    	
	}
	
	public static void main(String[] args) {
		
		//nextGreaterElement(new int[] {2,1,2,4,3});
		nextGreaterElement_q(new int[] {2,1,2,4,3});
	}
	
	//QUESTION IS CAN I DO IT WITH MONOTONIC QUEUE?
	//LETS TRY THAT
	
	static void nextGreaterElement_q(int[] nums) {
		
		//FROM RIGHT, BECAUSE WE KNOW THE LAST VALUE WILL CORRESPOND TO -1
		
		Deque<Integer> q = new LinkedList<>();
		for (int i=nums.length-1; i>=0; i--) {
			
			System.out.println(peek(q, nums[i]));
			push(q, nums[i]);
		}
	}
	
	static void push(Deque<Integer> q, int n) {
		
		while (!q.isEmpty() && q.peekLast()<n) {
			q.pollLast();
		}
		q.offer(n);
	}
	
	static void pop(Deque<Integer> q, int n) {
		if (!q.isEmpty() && q.peek()==n)
			q.poll();
	}
	
	static int peek(Deque<Integer> q, int n) {
		if (q.isEmpty()) return -1;
		while (!q.isEmpty() && q.peekLast()<n) {
			q.pollLast();
		}
		return q.peekLast()<=n?-1:q.peekLast();
	}
	
}
