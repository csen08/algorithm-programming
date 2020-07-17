/**
 * LEETCODE 347
 */
package programming.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	
	public static int[] topKFrequent(int[] nums, int k) {
        
        //idea is to build a hashmap with the count
        //Build a max heap(max at top) with size=k ..NO!!!
        //we will cut the head, so build a min heap, where max will be at bottom
        
        Map<Integer,Integer> count_hash = new HashMap<>();
        for (int x:nums){
            count_hash.put(x, count_hash.getOrDefault(x,0)+1);
        }
        
//        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(k+1,Map.Entry.comparingByValue());
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer,Integer>>(k+1,(e1, e2)->{
        	return e1.getValue().compareTo(e2.getValue());
        });
        
        for (Map.Entry<Integer,Integer> y: count_hash.entrySet()) {
        	minHeap.offer(y);
        	if (minHeap.size()>k) {
        		minHeap.poll();
        	}
        }
        
        int[] res = new int[minHeap.size()];
        int idx=0;
        while (!minHeap.isEmpty()) {
        	Map.Entry<Integer,Integer> e = minHeap.poll();
        	res[idx] = e.getKey();
        	idx++;
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));
		
		int[] nums1 = new int[] {1};
		int k1 = 1;
		System.out.println(Arrays.toString(topKFrequent(nums1, k1)));
	}

}
