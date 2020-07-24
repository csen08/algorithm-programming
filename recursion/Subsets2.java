package programming.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets2 {
	//a modified approach

	
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<>();
		subsets.add(new ArrayList(current));
		
		//find_subsets(nums, 0, current, subsets);		
		toFindAllSubsets(nums, subsets, current, 0);
		
		return subsets;
	}

//	private void find_subsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
//		
//		subsets.add(new ArrayList(current));
//		for (int i=index;i<nums.length;i++) {
//			
//			current.add(nums[index]); //change index to i
//			find_subsets(nums, i+1, current, subsets);
//			current.remove(current.size()-1);
//		}
//	}
	
	  private void toFindAllSubsets(int[] nums, List<List<Integer>> results, List<Integer> subset, int startIndex) {
	        	        
	        for (int i = startIndex; i < nums.length; i++) {
	            subset.add(nums[i]);
	            results.add(new ArrayList<>(subset));
	            toFindAllSubsets(nums, results, subset, i + 1);
	            subset.remove(subset.size() - 1);
	            System.out.println(i);
	        }        
	    }
	
	 public static void main(String[] args) {
			
	    	Subsets2 inSubsets = new Subsets2();
	    	System.out.println(inSubsets.subsets(new int[] {1,2,3}));
	    	inSubsets.subsets(new int[] {0});
		}
}
