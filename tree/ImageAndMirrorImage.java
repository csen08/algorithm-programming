package programming.tree;

public class ImageAndMirrorImage {
	
	/**
	 * Different types of problems can be,
	 * check if they are mirror image?
	 * or convert a binary tree into mirror image
	 *
	 */

	class Node {
		int val;
		Node left, right;
		public Node(int n) {
			val = n;
		}
	}
	
	public static boolean isImage(Node first, Node second) {
		
		if (first==null && second==null)  return true;//Base condition: both null
		else if (first!=null && second!=null) {
			return ((first.val == second.val) && isImage(first.left, second.left)
					&& isImage(first.right, second.right));
		}
		else
			return false;
	}
	
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
	
	public static void print_in_order(Node root) {
		
		if (root == null) return;//base condition
		print_in_order(root.left);
		System.out.print(root.val +"-->");
		print_in_order(root.right);
	}
	
	public static void main(String[] args) {
		
		ImageAndMirrorImage instance = new ImageAndMirrorImage();
		Node root = instance.new Node(1);
		root.left = instance.new Node(2);
		root.right = instance.new Node(3);
		root.left.left = instance.new Node(4);
		root.left.right = instance.new Node(5);
		root.right.left = instance.new Node(6);
		root.right.right = instance.new Node(7);
		
		print_in_order(root);
		System.out.println();
		mirrot_It(root);
		
		print_in_order(root);
	}
}
