package programming.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTravarsal {
	
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
	
	class Pair<T,R>{
		T first;
		R second;
		
		Pair(T f, R s){
			this.first=f;
			this.second=s;
		}
		T getFirst() {
			return first;
		}
		R getSecond() {
			return second;
		}
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		
		Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
		Map<Integer, List<Integer>> m = new HashMap<>();
		q.offer(new Pair<TreeNode,Integer>(root, 0));//root is column=0, left side decreases by 1, right side increases by 1
		int min=0,max=0;
		
		while (!q.isEmpty()) {
			
			int size=q.size();
			for (int i=0;i<size;i++) {
				Pair<TreeNode, Integer> p = q.poll();
				TreeNode t = p.getFirst();
				Integer col = p.getSecond();
				m.putIfAbsent(col, new ArrayList<>());
				m.get(col).add(t.val);
				if (t.left!=null) {
					min=Math.min(min, col-1);
					q.offer(new Pair<TreeNode,Integer>(t.left,col-1));
				}
				if (t.right!=null) {
					max=Math.max(max, col+1);
					q.offer(new Pair<TreeNode,Integer>(t.right,col+1));
				}
			}
		}
		
		for (int p=min;p<=max;p++) {
			res.add(m.get(p));
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		VerticalOrderTravarsal instance = new VerticalOrderTravarsal();
		
		/**
		 *         3
		 *        /	 \
			    /	   \
			   /  		\
			   9		 8
			  /\ 	 	 /\
			 /  \		/  \
			 4  0		1   7
			     \	   /
			      2	  5
			     
		 */
		TreeNode root = instance.new TreeNode(3);
		root.left = instance.new TreeNode(9);
		root.right = instance.new TreeNode(8);
		root.left.left = instance.new TreeNode(4);
		root.left.right = instance.new TreeNode(0);
		root.left.right.right = instance.new TreeNode(2);
		root.right.left = instance.new TreeNode(1);
		root.right.right = instance.new TreeNode(7);
		root.right.left.left = instance.new TreeNode(5);
		System.out.println(instance.verticalOrder(root));
		
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
		System.out.println(instance.verticalOrder(root2));
		
		
	}

}
