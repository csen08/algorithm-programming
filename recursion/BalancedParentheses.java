package programming.recursion;

import java.util.Stack;

public class BalancedParentheses {
	
	public static boolean is_balanced(String s) {
		
		if (s == null || s.length()==0) return true; //base case
		
		Stack<Character> parenthesesStack = new Stack<>();
		char[] chars = s.toCharArray();
		
		for (int i=0; i< chars.length;i++) {
			char c = chars[i];
			
			if (c=='(' || c=='{' || c=='[') {
				parenthesesStack.push(c);
			}
			else if (c == ')') {
				if  (parenthesesStack.isEmpty() || parenthesesStack.peek() != '(' ) //empty check is must, input string can be ")}]"
					return false;
				else
					parenthesesStack.pop(); //pop the starting to keep the balance
			}
			else if (c == '}') {
				if  (parenthesesStack.isEmpty() || parenthesesStack.peek() != '{' )
					return false;
				else
					parenthesesStack.pop();
			}
			else if (c == ']') {
				if  (parenthesesStack.isEmpty() || parenthesesStack.peek() != '[' )
					return false;
				else
					parenthesesStack.pop();
			}
				
		}
		
		return parenthesesStack.isEmpty()?true:false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(is_balanced("[()]{}{[()()]()}"));//true
		System.out.println(is_balanced("[(])"));//false
		System.out.println(is_balanced(""));//true
	}
}