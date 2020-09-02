package programming.monotonic;

import java.util.Deque;
import java.util.LinkedList;

public class Max_value_in_a_sliding_window {
	
	//monotonic queue implementation - it is a Deque - double ended queue
	//https://anthony-huang.github.io/competitiveprogramming/2016/06/06/monotonic-queue.html
	//https://leetcode.com/problems/sliding-window-maximum/discuss/65885/This-is-a-typical-monotonic-queue-problem
	
	class MonoQueue{
		
		//mono queue will have push(n) and pop(n) and front() methods
		//strictly increasing monotonic queue-> front() will have min value
		//strictly decreasing -> front() will have min value
		
		//since we need max here, we need this max to be at front, so we need strictly increasing mono queue
		
		Deque<Integer> q = new LinkedList<>();
		
		void push(int n) {
			// case 1: 8 -> 6 -> 5 -> 10 ... Here 10 will pop out all
			// case 2: 11 -> 8 -> 6 -> 10 ... Here 10 will pop out all till 8
			
			while (!q.isEmpty() && q.peekLast()<n) {
				q.pollLast();
			}
			q.offer(n);
		}
		
		void pop(int n) {
			//if we need to pop an element, we need to pop all below it?
			
			//No .. just pop if it is in front, else ignore
			
			if (q.peekFirst().equals(n))
			{
				q.pollFirst();
			}
		}
		
		int front() {
			return q.peek();
		}
		
	}
	
	void max_in_subarray_window_k(int[] arr, int k) {
		
		MonoQueue mq = new MonoQueue();
		
//		for (int i=0; i<k; i++) {
//			mq.pop(arr[i]);
//		}
		
		for (int i=0; i< arr.length; i++) {
			if (i<k-1)
				mq.push(arr[i]);
			else {
				
				mq.push(arr[i]);
				System.out.print(mq.front()+" ");
				mq.pop(arr[i-k+1]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Max_value_in_a_sliding_window ins = new Max_value_in_a_sliding_window();
		ins.max_in_subarray_window_k(new int[] {1,3,-1,-3,5,3,6,7}, 3);
	}

}
