package programming.tree;

public class IsBalanced {
	
	/**
	 * Balanced tree - A tree is said to be balanced if its left and right sub trees
	 * are balanced AND their height differ by at most 1.
	 * 
	 * An empty tree is height-balanced. A non-empty binary tree T is balanced if:
	 * 1) Left subtree of T is balanced
	 * 2) Right subtree of T is balanced
	 * 3) The difference between heights of left subtree and right subtree is not more than 1.
	 * 
	 */
	
	public static boolean isBalanced(Node root) {
		if (root == null)
			return true;
		
		boolean leftBalanced = isBalanced(root.left);
		boolean rightBalanced = isBalanced(root.right);
		
		int leftHeight=height_of_a_tree(root.left);
		int rightHeight=height_of_a_tree(root.right);
		
		return (leftBalanced && rightBalanced && Math.abs(leftHeight-rightHeight)<2);
	}
	
	private static int height_of_a_tree(Node root) {
		
		if (root == null) //base condition
			return 0;
		
		return (Math.max(height_of_a_tree(root.left), height_of_a_tree(root.right))+1);
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
		
		System.out.println(isBalanced(root));//true
		
	    /* Construct below tree
		        1
		      /   \
		     /     \
		    2       3
		   / \     
		  4   5   
		 /     
		9
	     */		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		root2.left.left.left = new Node(9);
		
		System.out.println(isBalanced(root2));//false
		
	}

}
