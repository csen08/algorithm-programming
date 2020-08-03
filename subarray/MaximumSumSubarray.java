package programming.subarray;

public class MaximumSumSubarray {
	
	int maxSum(int[] arr) {
		
		int max_sum=0;//Integer.MIN_VALUE when negative value allowed
		int curr_sum=0;
		
		for (int x : arr) {
			curr_sum=Math.max(0, curr_sum+x);//0 or when negative allowed, it would be x.
			max_sum=Math.max(max_sum, curr_sum);
		}
		int s=-1,t=-1;
        for (char c: "as".toCharArray()){
            if (c=='#'){
                s=(s==-1) ? s :s--;
            
            }
        }
		
		return max_sum;
	}
	
	public int maxProduct(int[] nums) {
	    int[] max = new int[nums.length];
	    int[] min = new int[nums.length];
	 
	    max[0] = min[0] = nums[0];
	    int result = nums[0];
	 
	    for(int i=1; i<nums.length; i++){
	        if(nums[i]>0){
	            max[i]=Math.max(nums[i], max[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], min[i-1]*nums[i]);
	        }else{
	            max[i]=Math.max(nums[i], min[i-1]*nums[i]);
	            min[i]=Math.min(nums[i], max[i-1]*nums[i]);
	        }
	 
	        result = Math.max(result, max[i]);
	    }
	 
	    return result;
	}

}
