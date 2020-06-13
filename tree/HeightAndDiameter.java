package programming.tree;

import java.util.concurrent.atomic.AtomicInteger;

public class HeightAndDiameter {
		
	class Node  {
		int val;
		Node left,right;
		
		public Node(int n) {
			val = n;
		}
	}
	
	
	public static int height_of_a_tree(Node n) {
		
		if (n== null)//base condition, 
			//in tree recursive problems, always this is base condition. 
			return -1;
		else
			return (1+Math.max(height_of_a_tree(n.left), height_of_a_tree(n.right)));
	}
	
	public static int diameter_of_a_tree(Node n, AtomicInteger diameter) {
		//diameter calculation is similar as height calculation
		//with some twist
		
		//code what we will write here is same as height calculation
		//https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
		//diameter of a tree is the max value of (left_height+right_height+1) for each node
		
		if (n == null )//base case
			return 0;
		
		//calculate height of left sub tree and right sub tree
		int L = diameter_of_a_tree(n.left, diameter);
		int R = diameter_of_a_tree(n.right, diameter);
		
		diameter.set(Math.max(diameter.get(), L+R+1));
		
		return 1+Math.max(L, R);
	}

	
	public static void main(String[] args) {
		
		HeightAndDiameter hd = new HeightAndDiameter();
		Node root = hd.new Node(1);
		root.left = hd.new Node(2);
		root.right = hd.new Node(3);
		root.left.left = hd.new Node(5);
		root.left.right = hd.new Node(4);
		root.right.left = hd.new Node(6);
		root.right.right = hd.new Node(7);
		
		System.out.println("Height ="+height_of_a_tree(root));
		
		AtomicInteger ai = new AtomicInteger(1);
		diameter_of_a_tree(root, ai);
		System.out.println("Diameter ="+(ai.get()-1));
	}

}
