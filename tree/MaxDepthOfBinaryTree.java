package programming.tree;

import java.util.ArrayDeque;

public class MaxDepthOfBinaryTree {
	/**
	 * Definition: The height of binary tree is the longest path from root to any leaf node in the tree
	 * There are different type of problems we can have related to this
	 * Also known a height of binary tree
	 * Can be done with recursion
	 * Level=easy
	 */
	
	// lets create the node first
	class Node {
		int data;
		Node left,right;
		
		//constructor
		Node(int info) {
			data=info;
			left=right=null;
		}
	}
	
	
	Node root;
	
	/**
	 * recursive approach
	 */
	static int height(Node root) {
		
		if (root==null)		return 0;
		return (1+Math.max(height(root.left), height(root.right)));
	}
	
	/**
	 * iterative approach
	 */
	static int height_iterative_approach(Node root) {
		
		int height=0;
		ArrayDeque<Node> deque = new ArrayDeque<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			height++;
			
			for (int i=0;i<deque.size();i++) {
				Node n = deque.poll();
				if (n.left !=null) deque.add(n.left);
				if (n.right !=null) deque.add(n.right);
			}
		}
			
		return height;
		
	}
	
	
	public static void main(String[] args) {
		MaxDepthOfBinaryTree bt = new MaxDepthOfBinaryTree();
		bt.root = bt.new Node(1);
		bt.root.left = bt.new Node(2);
		bt.root.right = bt.new Node(3);
		bt.root.left.left=bt.new Node(4);
		bt.root.left.left.left=bt.new Node(5);
		
		System.out.println("Height is=" +height(bt.root));
		
		System.out.println("Height is=" +height_iterative_approach(bt.root));
	}
}
