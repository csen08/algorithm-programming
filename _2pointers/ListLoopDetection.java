package programming._2pointers;

/**https://howtodoinjava.com/puzzles/how-to-detect-infinite-loop-in-linkedlist-in-java-with-example/
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 * 
What interview is looking for is, Floyd's Cycle-Finding Algorithm“.

This problem can be solved in different ways

Using hashing, brute force
Traverse the list one by one and put the node addresses in a hash table.
1. Push first node, start from next node
2. If current node is null, no loop
	2.1. If current node is not null, search for this node in the hashtable
		2.1.1. If found, then loop
		2.1.2. If not found, push it's address to the hashtable, and go to next

Using Mark Visited Node
Modify the Node structure, and add a flag called visited, set as FLASE,
Go to each node one by one, if visited=TRUE, means loop, RETURN
If NULL has reached, no loop
*/

public class ListLoopDetection {
	//Floyd's cycle finding algorithm
	
	class Node {
		int value;
		Node next;
		
		Node(int v) {
			this.value=v;
			this.next=null;
		}
	}
	
	//Method pushes a node at the front of a list
	
	Node head;
	private void pushAtFront(int data) {
		
		Node n = new Node(data);
		n.next=head;
		head=n;
	}
	
	private void pushAtEnd(int data) {
		
		Node n = new Node(data);
		// In this case, we need two pointers, one at beginning, and one at the end,
		// we always need to end pointer
		
	}
	
	private boolean detectLoop() {
		Node slow_p=head,fast_p=head;
		
		while (slow_p!=null && fast_p !=null && fast_p.next!=null) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
			if (slow_p == fast_p) return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		ListLoopDetection ld = new ListLoopDetection();
		ld.pushAtFront(5);
		ld.pushAtFront(4);
		ld.pushAtFront(3);
		ld.pushAtFront(2);
		ld.pushAtFront(1);
		
		ld.head.next.next.next.next.next=ld.head;
		
		System.out.println("Loop Detected:"+ld.detectLoop());
	}
	

}
