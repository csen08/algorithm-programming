package programming.tree;

import java.util.Stack;

public class LCA_of_binary_tree {

	//lowest common ancestor
	//We will do it in two ways.
	
	//1. Find root-to-leaf path for each of the nodes, and compare two paths
	
	//2. we will find the LCA in left-sub-tree and right-sub-tree recursively 
	
	
	//1.
	public static int findLCA(Node root, int x, int y) {
		
		Stack<Integer> p1 = find_root_to_leaf(root, x);
		Stack<Integer> p2 = find_root_to_leaf(root, y);
		
		//pop from stack
		
		if (p1 == null || p2 == null)
			return -1;
		
		int prev = -1;
		while (!p1.isEmpty() && !p2.isEmpty()) {
			if (p1.peek()==p2.peek()) {
				prev = p1.peek();
				p1.pop();
				p2.pop();
			}
			else
				break;
		}
		
		return prev;
	}
	
	public static Stack<Integer> find_root_to_leaf(Node root, int val) {
		
		//base condition
		if (root == null) return null;//always start with base condition
		
		if (root.value == val) {
			Stack<Integer> st = new Stack<>();
			st.push(root.value);
			return st;
		}
		
		//think here as parent of desired val. What you do? You see if you left has value? then add itself and return
		Stack<Integer> L = find_root_to_leaf(root.left, val); 
		if (L !=null) {
			L.push(root.value);
			return L;
		}
		
		Stack<Integer> R = find_root_to_leaf(root.right, val);
		if (R !=null) {
			R.push(root.value);
			return R;
		}
		
		return null;
	}
	
	//2.Finding LCA in left-sub-tree and right-sub-tree recursively
	//https://www.youtube.com/watch?v=F-_1sbnPbWQ
	public static Node findLCA_recursively(Node root, int x, int y) {
		
		if (root == null) return null; //1. base condition
		
		if (root.value == x || root.value == y) return root; //2. second condition
		
		Node L = findLCA_recursively(root.left,x,y);
		Node R = findLCA_recursively(root.right,x,y);
		
		//Below 4 conditions are important
		if (L!=null && R!=null) return root;//if left and right
		else if (L!=null) return L;
		else if (R!=null) return R;
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
		
		System.out.println("findLCA :"+findLCA(root, 7, 8));
		
		System.out.println("findLCA_recursively :"+findLCA_recursively(root, 6, 8).value);
	}
	
}
