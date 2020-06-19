package programming._2pointers;

public class LinkedListProblems {

	class Node {
		int value;
		Node next;
		Node(int val) {
			this.value = val;
		}
	}
	
	/**
	 * 1. Find K'th element from end in a linked list
	 */	
	public static int kth_from_end(Node head, int k) {
		
		Node first = head;
		Node second = head;
		
		int i=1;
		
		while (i<k) {
			second = second.next;
			i++;
		}
		System.out.println(second.value);
		while (first != null && second.next != null) { 
			//{second.next} because I want second pointer to be positioned at the end.
			//Not after end.
			first = first.next;
			second = second.next;
		}
		return first.value;
	}
	
	
	/**
	 * 2. Find middle element in a linked list
	 */
	public static int middle_element(Node head) {
		
		//code not checking length is even or odd
		Node slow_p = head;
		Node fast_p = head;
		
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
		}
		
		return slow_p.value;
	}
	
	public static void main(String[] args) {
		
		LinkedListProblems instance = new LinkedListProblems();
		Node head = instance.new Node(1);
		head.next = instance.new Node(2);
		head.next.next = instance.new Node(3);
		head.next.next.next = instance.new Node(4);
		head.next.next.next.next = instance.new Node(5);
		head.next.next.next.next.next = instance.new Node(6);
		head.next.next.next.next.next.next = instance.new Node(7);
		head.next.next.next.next.next.next.next = instance.new Node(8);
		head.next.next.next.next.next.next.next.next = instance.new Node(9);
		// 1->2->3->4->5->6->7->8->9
		
		print_it(head);
		System.out.println();
		
		int k = 3;
		System.out.println(k+" from end = "+ kth_from_end(head, k));
		System.out.println();
		System.out.println("Middle element= " +middle_element(head));
	}
	
	private static void print_it(Node head) {
//		while (head != null) {
//			System.out.print(head.value+"-->");
//			head = head.next;
//		}
		
		//above code prints --> after last element, better approach is below,
		while (head.next != null) {
			System.out.print(head.value+"-->");
			head = head.next;
		}
		System.out.print(head.value);
	}
}
