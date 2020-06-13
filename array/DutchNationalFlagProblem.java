package programming.array;

import java.util.Arrays;

public class DutchNationalFlagProblem {
	
	/**
	 * sort an array containing 0's, 1's and 2's
	 * We will solve a variant of this as well, where
	 * sort an array containing 0's and 1's
	 * 
	 * Sorting will happen in space
	 * A brute force approach can solve it in O(NlogN)
	 * We need O(N)
	 */
	
	public static void sortArray(int[] arr) {
		
		//Idea is, we will work with 3 pointers here
		//left, right and mid
		//mid is the index value and based on this, we will swap 0's and 2's
		// we will skip 1's. Idea is if we sort 0's and 2's, 1's will fall in place.
		
		//In place and linear time
		int left=0,mid=0,right=arr.length-1;
		
		while (mid<=right) {//algorithm stops once the mid pointer passes the right pointer
			
			if (arr[mid]==0) {//swap left and mid
				int temp = arr[left];
				arr[left]=arr[mid];
				arr[mid]=temp;
				left++;
				mid++;
			}
			
			else if (arr[mid]==1) {//do nothing
				mid++;
			}
			else if (arr[mid]==2) {//swap right
				int temp = arr[right];
				arr[right]=arr[mid];
				arr[mid]=temp;
				right--; //note here, no change in mid
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] arr = {0,1,0,1,2,0,1,1,1,2,0,0,2,2};
		System.out.println(Arrays.toString(arr));
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
		
		System.out.println();
		int[] arr2 = {1,1,0,0,1,0,1,0,1,0,1};
		System.out.println(Arrays.toString(arr2));
		sortArray_zero_one(arr2);
		System.out.println(Arrays.toString(arr2));
	}
	
	
	public static void sortArray_zero_one(int[] arr) {
		
		//two pointer approach,
		//from left and right, move 0's to the left and 1's to the right
		
//		int left=0,right=arr.length-1;
//		
//		while (left<=right) {
//			if (arr[left]==0) left++;
//			else if (arr[right]==1) right--;
//			else if (arr[left]==1) {
//				int temp=arr[left];
//				arr[left]=arr[right];
//				arr[right]=temp;
//				left++;
//			}
//			else if (arr[right]==0) {
//				int temp=arr[right];
//				arr[right]=arr[left];
//				arr[left]=temp;
//				right--;
//			}
//		}
		
		//3 pointer is easy, 
		//Exactly same way as it is done in Dutch flag problem with small changes
		int l=0,m=0,r=arr.length-1;
		
		while (m<=r) {
			if (arr[m]==0) {
				int temp=arr[l];
				arr[l]=arr[m];
				arr[m]=temp;
				l++;
				m++;
			}
			else if (arr[m]==1) {
				int temp=arr[r];
				arr[r]=arr[m];
				arr[m]=temp;
				r--;
			}
		}
	}
	
}
