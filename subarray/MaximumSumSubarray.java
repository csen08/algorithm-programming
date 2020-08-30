package programming.subarray;

public class MaximumSumSubarray {
	
	static int maxSum(int[] arr) {
		
		int max_so_far=0;//when negative value allowed, it would be Integer.MIN_VALUE
		int curr_sum=0;
		
		for (int x : arr) {
			curr_sum=Math.max(0, curr_sum+x);//0 or when negative allowed, it would be x.
			max_so_far=Math.max(max_so_far, curr_sum);
		}
		
		return max_so_far;
	}
	
	static int maxSumIndex(int[] arr) {
		
		int current_sum=0;
		int max_so_far=0;
		
		int current_start=0, current_end=-1, best_start=0, best_end=0;
		
		for (int a : arr) {
			current_end++;
			//current_sum=Math.max(0,  current_sum+a); //if sum becomes negative, set it to zero
			//max_so_far=Math.max(max_so_far, max_till_here);
			
			if (current_sum<0) {
				current_sum=0;//reset
				current_start=current_end;
			}
			else {
				current_sum=current_sum+a;
			}
			
			if (max_so_far<current_sum) {
				max_so_far=current_sum;
				best_start=current_start;
				best_end=current_end+1; //exclusive, so 1 added
			}
		}
		
		System.out.println(best_start);
		System.out.println(best_end);
		return max_so_far;
	}
	
	public static void main(String[] args) {
		
		System.out.println(maxSum(new int[] {1,2,3,5,-6,4,0,10}));
		System.out.println(maxSumIndex(new int[] {1,2,3,5,-6,4,0,10}));
	}

}
