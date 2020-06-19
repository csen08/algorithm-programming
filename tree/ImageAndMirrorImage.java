package programming.tree;

public class ImageAndMirrorImage {
	
	/**
	 * Different types of problems can be,
	 * 1. check if two binary tree same or not?
	 * 2. convert a binary tree into it mirror image?
	 * 3. check if a binary tree is sub-tree of a given tree?
	 *
	 */

	class Node {
		int val;
		Node left, right;
		public Node(int n) {
			val = n;
		}
	}
	
	/**
	 * 1. Two binary tree same or not 
	 */
	public static boolean isImage(Node first, Node second) {
		
		if (first==null && second==null)  return true;//Base condition: both null
		else if (first!=null && second!=null) {
			return (first.val == second.val) && isImage(first.left, second.left) && isImage(first.right, second.right);
		}
		else
			return false;
	}
	
	/**
	 * 2. Mirror 
	 */
	public static void mirrot_It(Node root) {
	
		mirrorIt_rec(root);
	}
	
	public static Node mirrorIt_rec(Node root) {
		
		if (root == null)
			return null;
		
		Node left = mirrorIt_rec(root.left);
		Node right = mirrorIt_rec(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	/**
	 * 3. Sub-tree or not?
	 */
	public static boolean isSubTree(Node s, Node t) {
		
		if (s == null) //base case, this is needed for the recursive call
			return false;
		else if (isSameTree(s, t)) //image check algorithm
			return true;
		else
			return isSubTree(s.left, t) || isSubTree(s.right, t);
	}
	
	// checking if a and b are image(same)
	private static boolean isSameTree(Node a, Node b) {
		
		if (a == null && b == null)
			return true;
		else if (a != null && b != null) return  (a.val == b.val) && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
		else
			return false;
	}
	
	public static void print_in_order(Node root) {
		
		if (root == null) return;//base condition
		print_in_order(root.left);
		System.out.print(root.val +"-->");
		print_in_order(root.right);
	}
	
	public static void main(String[] args) {
		
	    /* Construct below tree
		        1
		      /   \
		     /     \
		    2       3
		   / \     / \
		  4   5   6   7
		               
	     */
		ImageAndMirrorImage instance = new ImageAndMirrorImage();
		Node root = instance.new Node(1);
		root.left = instance.new Node(2);
		root.right = instance.new Node(3);
		root.left.left = instance.new Node(4);
		root.left.right = instance.new Node(5);
		root.right.left = instance.new Node(6);
		root.right.right = instance.new Node(7);
		
		Node root2 = instance.new Node(1);
		root2.left = instance.new Node(2);
		root2.right = instance.new Node(3);
		root2.left.left = instance.new Node(4);
		root2.left.right = instance.new Node(5);
		root2.right.left = instance.new Node(6);
		root2.right.right = instance.new Node(7);
		
		System.out.println(isImage(root, root2));
		
		Node root3 = instance.new Node(1);
		root3.left = instance.new Node(2);
		root3.right = instance.new Node(3);
		root3.left.left = instance.new Node(4);
		root3.left.right = instance.new Node(5);
		root3.right.left = instance.new Node(6);
		
		System.out.println(isImage(root, root3));
		
		print_in_order(root);
		System.out.println();
		mirrot_It(root);
		
		print_in_order(root);
		System.out.println();
		
		Node root4 = instance.new Node(2);
		root4.left = instance.new Node(4);
		root4.right = instance.new Node(7);
		
		Node root5 = instance.new Node(1);
		root5.left = instance.new Node(2);
		root5.right = instance.new Node(3);
		root5.left.left = instance.new Node(4);
		root5.left.right = instance.new Node(5);
		root5.right.left = instance.new Node(6);
		root5.right.right = instance.new Node(7);
		
		System.out.println(isSubTree(root5, root4));
		
	}
}
