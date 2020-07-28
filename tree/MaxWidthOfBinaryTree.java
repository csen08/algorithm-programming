/**
 * Leetcode 662
 */
package programming.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


public class MaxWidthOfBinaryTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return this.val+"";
		}
	}

	public static int widthOfBinaryTree(TreeNode root) {
		ArrayDeque<List<Object>> q = new ArrayDeque<>();

		int max_width=0;
		q.offer(makePair(root,0));
		while (!q.isEmpty()) {
			
			int size = q.size();
			int leftmost = (Integer)q.peek().get(1); //leftmost index in this level
			int rightmost = leftmost;
			for (int i=0;i<size;i++){ //at each level, loop over the elements
				List<Object> l = q.poll();
				TreeNode tn=(TreeNode)l.get(0);
				int t_idx = (Integer)l.get(1);
				rightmost = t_idx;  //update rightmost index in this level
				if (tn.left!=null) q.offer(makePair(tn.left,t_idx*2+1-leftmost)); //possible overflow, so minus from leftmost index in this level
				if (tn.right!=null) q.offer(makePair(tn.right,t_idx*2+2-leftmost));
			}
			//In this level, find the index different between leftmost and rightmost and compare with max
			max_width = Math.max(max_width, rightmost-leftmost+1);
		}
		
		return max_width;
	}

	public static List<Object> makePair(TreeNode n, int idx){
		List<Object> l = new ArrayList<>();
		l.add(n);
		l.add(idx);
		return l;
	}

	public static void main(String[] args) {

		/**
		 *     
			       1
		         /   \
		        3     2
		       / \     \  
		      5   3     9 
		 */

		MaxWidthOfBinaryTree instance = new MaxWidthOfBinaryTree();
		TreeNode root = instance.new TreeNode(1);
		root.left = instance.new TreeNode(3);
		root.right = instance.new TreeNode(2);
		root.left.left = instance.new TreeNode(5);
		root.left.right = instance.new TreeNode(3);
		root.right.right = instance.new TreeNode(9);

		System.out.println(widthOfBinaryTree(root));
		
		/**
		 *     
			       1
		         /   \
		        3     2
		       /       \  
		      5         9  
		     /           \ 
		    6             7
		 */
		TreeNode root2 = instance.new TreeNode(1);
		root2.left = instance.new TreeNode(3);
		root2.right = instance.new TreeNode(2);
		root2.left.left = instance.new TreeNode(5);
		root2.left.left.left = instance.new TreeNode(6);
		root2.right.right = instance.new TreeNode(9);
		root2.right.right.right = instance.new TreeNode(7);

		System.out.println(widthOfBinaryTree(root2));
	}

}
