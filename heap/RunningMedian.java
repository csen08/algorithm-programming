package programming.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

	//find the running median
	/** What is median
	 * The middle value of a sorted array
	 * If the array size is even, then average of middle 2 values 
	 */
	//brute-force algorithm is to use insertion sort
	//why insertion sort is better is explained here
	//https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
	// insertion sort complexity is O(n*2)
	
	PriorityQueue<Integer> uppers = new PriorityQueue<Integer>(); // default is min heap, where min value is at top
	PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(Collections.reverseOrder()); // it is max heap, where max value is at top
	
	public double findMedian(int input) {
		
		//once we have the heaps, we will insert either of them
		addNumber(input, uppers, lowers);
		
		//we need to keep track of middle value, so both heaps will have same size or difference not more than 1 element
		//in case of even number of inputs, both of the heaps will have same number of elements
		//the heap which will have more element
		rebalance(uppers, lowers);
		
		return getMedian(uppers,lowers);
		
	}
	
	private void addNumber(int ip, PriorityQueue<Integer> uppers, PriorityQueue<Integer> lowers) {
		//we need to insert into any of the heap comparing the top element
		//when both are empty we can start from lowers
//		if (lowers.isEmpty() && uppers.isEmpty())
		if (lowers.isEmpty() || ip< lowers.peek())
			lowers.add(ip);
		else
			uppers.add(ip);
	}
	
	private void rebalance(PriorityQueue<Integer> uppers, PriorityQueue<Integer> lowers) {
		//rebalance is nothing but check the heap size, and balance them
		//maintain diff not more than 1
		if (uppers.size() > lowers.size()+1) {
			//take out from upper and push it to lowers
			lowers.add(uppers.poll());
		}
		if (lowers.size() > uppers.size()+1) {
			//take out from lowers and push it to uppers
			uppers.add(lowers.poll());
		}
	}
	
	private double getMedian(PriorityQueue<Integer> uppers, PriorityQueue<Integer> lowers) {
		
		if (uppers.size() == lowers.size()) {
			return (uppers.peek()+lowers.peek())/2.0;
		}
//		else if (uppers.size()>lowers.size()) {
//			return uppers.peek();
//		}
//		else
//			return lowers.peek();
		else return uppers.size()>lowers.size()?uppers.peek():lowers.peek();
	}
	
	public static void main(String[] args) {
		
		//A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		RunningMedian rm = new RunningMedian();
		System.out.println("Adding 5, now the median is ="+rm.findMedian(5));
		System.out.println("Adding 15, now the median is ="+rm.findMedian(15));
		System.out.println("Adding 1, now the median is ="+rm.findMedian(1));
		System.out.println("Adding 3, now the median is ="+rm.findMedian(3));
		System.out.println("Adding 2, now the median is ="+rm.findMedian(2));
		System.out.println("Adding 8, now the median is ="+rm.findMedian(8));
		System.out.println("Adding 7, now the median is ="+rm.findMedian(7));
		System.out.println("Adding 9, now the median is ="+rm.findMedian(9));
		System.out.println("Adding 10, now the median is ="+rm.findMedian(10));
		System.out.println("Adding 6, now the median is ="+rm.findMedian(6));
		System.out.println("Adding 11, now the median is ="+rm.findMedian(11));
		System.out.println("Adding 4, now the median is ="+rm.findMedian(4));
	}
}
