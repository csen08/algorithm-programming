package programming.tree;

public class Node implements Comparable<Node>{
	int value;
	Node left,right;
	
	public Node(int input) {
		value = input;
	}
	
	@Override
	public int compareTo(Node o) {
		if (this.value>o.value) return 1;
		if (this.value<o.value) return -1;
		return 0;
	}
}
