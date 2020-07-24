/**
 * Leetcode 78
 */
package programming.recursion;

import java.util.*;

public class Subsets {
    
    private Set<String> s = new HashSet<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        
        Arrays.sort(nums);//sorted
        List<Integer> nums_list = new ArrayList<>();
        
        for (int i=0;i<nums.length;i++) {
            
            nums_list.add(nums[i]);
        }
        
        res = subsets_rec(nums_list);
        res.add(0,new ArrayList<>());
        
        return res;
    }
    
    public List<List<Integer>> subsets_rec(List<Integer> nums) {
        
        
        if (nums.size()>2) {
            int val = nums.get(0);
            nums.remove(0);
            List<List<Integer>> op = subsets_rec(nums);
            List<Integer> t = new ArrayList<>();
            t.add(val);
            List<List<Integer>> op1 = new ArrayList<>();
            for (List<Integer> l:op){
                op1.add(new ArrayList(l));
            }
            
            for (List<Integer> l:op){
                l.add(0,val);
            }
            
            op1.add(0,t);
            op1.addAll(op);
            
            return op1;
        }
        if (nums.size()==2){
            List<List<Integer>> op = new ArrayList<>();
            if (!s.contains(nums.get(0)+"")){
                s.add(nums.get(0)+"");
                List<Integer> l = new ArrayList<>();
                l.add(nums.get(0));
                op.add(l);
            }
            if (!s.contains(nums.get(1)+"")){
                s.add(nums.get(1)+"");
                List<Integer> l = new ArrayList<>();
                l.add(nums.get(1));
                op.add(l);
            }
            if (!s.contains(nums.get(0)+"_"+nums.get(1))){
                s.add(nums.get(0)+"_"+nums.get(1));
                List<Integer> l = new ArrayList<>();
                l.add(nums.get(0));
                l.add(nums.get(1));
                op.add(l);
            }
            return op;
        }
        
        else {
        	List<List<Integer>> op = new ArrayList<>();
        	op.add(nums);
        	return op;
        }
    }
    
    public static void main(String[] args) {
		
    	Subsets inSubsets = new Subsets();
    	inSubsets.subsets(new int[] {0});
    	
	}
    
    
}