package programming.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {

	//Sort a nearly sorted array 
	//https://www.techiedelight.com/sort-k-sorted-array/
	//use heap
	//  idea is, create a min heap of size k+1. Min heap so that minimum value goes at top
	//populate k+1 elements
	//pop the top
	//push next
	
	//question can be to update in same array
	public static void solution(int[] array, int k) {
		
		PriorityQueue<Integer> minheap = new PriorityQueue<>(k+1);
		int x=0;
		for (int i : array) {
			minheap.add(i);
			if (minheap.size()>k) {
				array[x]=minheap.poll();//cut the head, and save it in the array
				x++;
			}
		}
		
		//loop ended, copy the remaining from the heap to array
		while (!minheap.isEmpty()) {
			array[x]=minheap.poll();
			x++;
		}
	}
	
	public static void main(String[] args) {
		
		int[] array = {1,4,5,2,3,7,8,6,10,9};
		System.out.println("Before sort");
		System.out.println(Arrays.toString(array));
		solution(array, 2);
		System.out.println("After sort");
		System.out.println(Arrays.toString(array));
		
	}
}
