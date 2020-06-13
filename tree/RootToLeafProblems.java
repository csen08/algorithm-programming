package programming.tree;

import java.util.Stack;

public class RootToLeafProblems {

	/**
	 * a variety type of problems
	 */
	
	class TreeNode {
		int val;
		TreeNode left, right;
		
		public TreeNode(int n) {
			val=n;
		}
	}
	
	//1. starting with a simple one
	//find the max sum from root to leaf
	public int maximum_sum_root_to_leaf(Node root) {
		
		if (root==null) // always start with base case
			return 0;
		
		int L = maximum_sum_root_to_leaf(root.left);
		int R = maximum_sum_root_to_leaf(root.right);
		
		//find out which sub tree has bigger sum? L or R?
		//whichever is big, add the current value to it and return
		
		//return (L>R?L:R) + root.value;
		return Math.max(L, R)+root.value;//better understanding
	}
	
	//2. Find the path with maximum sum from root to leaf
	public Stack<Integer> path_max_sum_root_to_leaf(Node root) {
		//whenever there is a question on path, we will use stack
		//we will take the bottom up approach(?)
		//1. we will find the max sum 
		
		
		return null;
		
	}
	
	
	//3. find/print all paths from root to leaf
	public static void printAllPaths_pre_order(Node root, Stack<Integer> st) {
		//As we traverse, we push to the stack
		//When it is leaf node, we print the stack, and pop the top
		
		//1. base condition
		//---------------------------------------------------------------------
		if (root == null) return;
		//---------------------------------------------------------------------
		
		
		//2.pre-order
		//---------------------------------------------------------------------
		st.push(root.value);// Process the root first, System.out.println(root.value);
		//---------------------------------------------------------------------
		
		
		//3. traverse left
		//---------------------------------------------------------------------
		printAllPaths_pre_order(root.left, st);
		//---------------------------------------------------------------------
		
		if (root.left == null && root.right == null) {
			System.out.println(st);//
		}
		
		//4. traverse right
		//---------------------------------------------------------------------
		printAllPaths_pre_order(root.right, st);
		//---------------------------------------------------------------------
		
		st.pop();//pop the element when both left and right traversal is completed
		
	}
	
	//4. Find/print root to leaf path with given sum
	public static void given_sum_root_to_leaf(Node root, int curr_sum, int desired_sum, Stack<Integer> st) {
		
		//again, we will do pre-order traversal.
		// we will push the value to the stack
		
		//1. base condition
		if (root == null) return;
		
		//2. push
		st.push(root.value);
		curr_sum+=root.value;
		if (curr_sum == desired_sum) {
			System.out.println(st);
			return;
		}
		
		//3. traverse left
		//---------------------------------------------------------------------
		given_sum_root_to_leaf(root.left, curr_sum, desired_sum, st);
		//---------------------------------------------------------------------
		
		//4. traverse right
		//---------------------------------------------------------------------
		given_sum_root_to_leaf(root.right, curr_sum, desired_sum, st);
		//---------------------------------------------------------------------
		
		st.pop(); // pop the element when both left and right traversal is done
		curr_sum-=root.value;
		
	}
	
	//4.1 - Alternative way, where we keep track of desired_sum-current_sum
//	public static Stack<Integer> given_sum_root_to_leaf_alternative(Node root, int curr_sum, int desired_sum) {
//		
//		//again, we will do pre-order traversal.
//		// we will push the value to the stack
//		
//		//1. base condition
//		if (root == null) return null;
//		
//		
//		//2. push
//		curr_sum =curr_sum - root.value;
//		if (curr_sum == 0) {
//			Stack<Integer> st = new Stack<>();
//			st.push(root.value);
//			return st;
//		}
//		
//		//3. traverse left
//		//---------------------------------------------------------------------
//		given_sum_root_to_leaf(root.left, curr_sum, desired_sum);
//		//---------------------------------------------------------------------
//		
//		//4. traverse right
//		//---------------------------------------------------------------------
//		given_sum_root_to_leaf(root.right, curr_sum, desired_sum);
//		//---------------------------------------------------------------------
//		
//		
//	}
	
	
	
	public static Stack<Integer> findPath(Node root, int val) {

		if (root == null ) return null;//base condition!!! always add
		if (root.value == val) { //additional condition
			Stack<Integer> st = new Stack<>();
			st.push(root.value);
			return st;
		}
		
		Stack<Integer> left = findPath(root.left, val);
		
		Stack<Integer> right = findPath(root.right, val);
		
		if (left != null) {
			left.push(root.value);
			return left;
		}
		if (right != null) {
			right.push(root.value);
			return right;
		}
		else return null;
	}
	
	
	
	public static void main(String[] args) {
		
	    /* Construct below tree
		        1
		      /   \
		     /     \
		    2       3
		   / \     / \
		  4   5   6   7
		         /     \
		        8       9
		*/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.left = new Node(8);
		root.right.right.right = new Node(9);
		
		//printAllPaths(root, "");
		//System.out.println(findPath(root, 8));
//		printAllPaths(root, new ArrayDeque<Integer>());
		
//		printAllPaths_pre_order(root, new Stack<>());
		
		given_sum_root_to_leaf(root, 0, 8, new Stack<>());
	}
}
