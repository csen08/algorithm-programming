package programming.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTravarsal {
	
	
	public static void inOrder(Node n) {
		if (n.left !=null) inOrder(n.left);
		System.out.print(n.value+"->");
		if (n.right !=null) inOrder(n.right);
	}
	
	//iterative approach does not have space complexity
	public static void inOrder_iterative(Node node) {
		
		while (node!=null) {
			
			if (node.left !=null) {
				node = node.left;
				continue;
			}
			System.out.print(node.value+"=>");
			if (node.right !=null) {
				node = node.right;
				continue;
			}
		}
	}
	
	public static void preOrder(Node n) {
		System.out.print(n.value+"=>");
		if (n.left !=null) preOrder(n.left);
		if (n.right !=null) preOrder(n.right);
	}
	
	public static void postOrder(Node n) {
		if (n.left != null) postOrder(n.left);
		if (n.right != null) postOrder(n.right);
		System.out.print(n.value+"->");
	}
	
	public static void lavelOrderTravarsal(Node n) {
		
		//Queue<Node> discoveredNodesQ = new PriorityQueue<Node>();
		//PriorityQueue is not good here, since it creates priority, rearranges the insertion order
		//Since PriorityQueue is holding type Node, we need to implement Comparable interface 
		//in Node class
		//LinkedList is correct, ArrayDeque is also preferable
		//http://brianandstuff.com/2016/12/12/java-arraydeque-vs-linkedlist/
		
		Queue<Node> discoveredNodesQ = new ArrayDeque<Node>();
		discoveredNodesQ.add(n);
		while(discoveredNodesQ.peek()!=null) {
			Node polled = discoveredNodesQ.poll();
			System.out.print(polled.value+"-->");
			if (polled.left!=null) discoveredNodesQ.add(polled.left);
			if (polled.right!=null) discoveredNodesQ.add(polled.right);
		}
	}
	
	//Using recursion
	public static void lavelOrderTravarsalRec(Queue<Node> q) {
		if (q.peek()!=null) {
			Node t = q.poll();
		
		System.out.print(t.value+"->");
		if (t.left != null) q.add(t.left);
		if (t.right !=null) q.add(t.right);
		lavelOrderTravarsalRec(q);
		}
	}
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(5);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		inOrder(root);
		System.out.println();
		inOrder_iterative(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		lavelOrderTravarsal(root);
		System.out.println();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		lavelOrderTravarsalRec(q);
	}

}
