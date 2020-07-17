package programming.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestOrSmallest {

	private static int kth_largest (int[] elements, int k) {

		//Priority Q
		//default heap is, minheap, where min value is at the queue top
		//max value is at queue bottom
		//when we cut the head, bottom remains unchanged
		//
		PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

		for (int i=0;i<elements.length; i++) {
			pq.add(elements[i]); // added at the end. 
			if (pq.size()>k) {//when it will be k+1, we will bring it down to k
				pq.poll();//polled at the beginning.
			}
		}
		return pq.peek();
	}

	/**
	 * To Find the K th smallest 
	 */
	private static int kth_smallest (int[] elements, int k) {

		//max heap - max value at the head, min value at the bottom
		//k-th min is at heap head
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

		for (int i=0;i<elements.length; i++) {
			pq.add(elements[i]);
			if (pq.size()>k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	// if question is first K largest elements
	// Idea is to populate the heap of K elements, and then loop on the heap

	public static void main(String[] args) {

		int k=3;
		int[] arr = {2,5,8,10,15,19,23};
		System.out.println("3 rd largest is "+kth_largest(arr, k));
		System.out.println("3 rd smallest is "+kth_smallest(arr, k));
		System.out.println();
		int[] arr2 = {4,5,8,2};
		System.out.println("3 rd largest is "+kth_largest(arr2, k));
		System.out.println("3 rd smallest is "+kth_smallest(arr2, k));
	}
}
