package programming.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	
	//now my approach is to handle it in O(1) space complexity
	//but result array is not count
	
	//1. Below is brute-force approach, time complexity is, O(N^2)
	public static int[] product_array_in_space(int[] arr) {
		
		// so basic idea is, start multiplication and skip the [i]th element
		// time complexity will raise to O(N*2)
		//this is not good
		
		int N = arr.length;
		int[] answer = new int[N];
		for (int i=0;i<N;i++) {
			
			int t=1;
			for (int j=0; j<N; j++) {
				if (i==j)
					continue;
				else
					t = t*arr[j];
			}
			answer[i]=t;
		}
		return answer;
		
	}
	
	public static int[] product_array(int[] nums) {
		
		/** we will have 2 arrays
		 * L array will have multiplications at left side
		 * R array will have multiplications at right side
		 * result[i] = L[i]*R[i]
		 */
		//
		
		int N = nums.length;
		int[] L = new int[N];
		L[0]=1;
		int[] R = new int[N];
		R[N-1]=1;
		
		int[] result=new int[N];
		//for-loop at left side, O(N)
		for (int i=1;i<N;i++)
			L[i]=L[i-1]*nums[i-1];
		
		//for-loop at right side O(N)
		for (int j=N-2;j>=0;j--)
			R[j]=R[j+1]*nums[j+1];
		
		//for-loop to merge
		for (int k=0;k<N;k++)
			result[k]=L[k]*R[k];
		
		//return result;
		
		/**
		 * 
		 * to do it in-space, we do not need R and result.
		 * We will modify L.
		 * So, L will have all the multiplications of the left side.
		 * 
		 * I need another variable R
		 * R will hold multiplication of numbers from right side, and in a loop we will multiply this number with L[i]
		 * 
		 */
		
		int r=1;
		//[2,3,4,5] will be store in L as, [1,2,6,24]
		//now loop, loop will start from right,
		//Because the right most value is already correctly set in L
		//and r=1
		//we will decrease, and increase the value of r
		for (int l=N-1;l>=0;l--) {
			L[l]=L[l]*r;
			r=r*nums[l];
			
		}
		
		return L;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(product_array_in_space(arr)));
		
		System.out.println();
		int[] arr2 = {1,2,3,4};
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(product_array(arr2)));
		
		
	}
	
}
