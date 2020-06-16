package programming.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	/**
	 * Given a positive integer n, write a program that prints all strings of length 
	 * 2n consisting of only open and closed parentheses that are balanced.
	 * 
	 * if n=2, ()() and (())
	 * 
	 * how recursion works wonderfully here
	 */
	
	
	public static void printIt(List<String>l, String s, int opening, int closing, int n) {
		
		if (opening == n && closing == n) {//base case
			l.add(s.toString());
			System.out.println(s.toString());
			return;
		}
		
		if (opening < n) { 
			printIt(l, s+"{", opening+1, closing, n);
		}
		if (closing < opening) {
			printIt(l, s+"}", opening, closing+1, n);
		}
		System.out.println("ending"+opening +closing);
	}
	
	//String buffer will not help, because the value stays in the buffer
	//below not working
	public static void printIt_using_StringBuffer(List<String>l, StringBuffer sb, int opening, int closing, int n) {
		
		if (opening == n && closing == n) {//base case
			l.add(sb.toString());
			System.out.println(sb.toString());
			return;
		}
		
		if (opening < n) { 
			printIt_using_StringBuffer(l, sb.append("{"), opening+1, closing, n);
		}
		if (closing < opening) {
			printIt_using_StringBuffer(l, sb.append("}"), opening, closing+1, n);
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println("ending"+opening +closing);
	}
	
	
	static int i=0;
	public static void printIt_char_array(List<String>l, int n, int opening, int closing, char[] c, int idx) {
		
		if (opening == n && closing == n) {//base case
//			l.add(s.toString());
			 // print the possible combinations 
            for(int i=0;i<c.length;i++) 
                System.out.print(c[i]); 
            System.out.println(); 
			return;
		}
		
		if (opening < n) {
			c[idx]='{';
			printIt_char_array(l, n, opening+1, closing, c, idx+1);//increment first
		}
		
		if (closing < opening) {
			c[idx]='}';
			printIt_char_array(l, n, opening, closing+1, c, idx+1);
		}
		
	}
	
	public static void main(String[] args) {
		
		int n=2;
		StringBuffer s = new StringBuffer();
		List<String> l = new ArrayList<String>(); //A holder to hold all combination
		printIt(l, "", 0, 0, n);
		//printIt(l, n, 0, 0, s);
		
		char[] c = new char[2*n];
//		System.out.println("Using char array");
		//printIt_char_array(l, n, 0, 0, c,0);
		
		//Using string buffer
		printIt_using_StringBuffer(l, new StringBuffer(), 0, 0, n);
	}
	
}
