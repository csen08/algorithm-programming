/**
 * https://www.techiedelight.com/find-minimum-number-deletions-convert-string-into-palindrome/
 */
package programming.recursion;

public class MinNumDelConvertStringToPalimdrome {
	//given a string we need to find minimum number of deletion to convert it to a palindrome
	
	
	//1. check from both ends, if T[i]==T[j], then i++, and j--
	//else. we can have 2 cases, but for sure we are increasing with 1
	//and then take the min of two cases, T[i+1..j] and T[i...j-1] and recursion
	
	
	public static int minDeletions(String X)
	{
		return minDeletionsRec(X, 0, X.length()-1);
	}
	
	static int minDeletionsRec(String x, int i, int j) {
		
		if (i>j) return 0;
		//if same, call recursively with i+1 and j-1
		//NOTE: it is i+1, not i++, not to be mistaken later
		
		if (x.charAt(i)==x.charAt(j)) {
			return minDeletionsRec(x, i+1, j-1);
		}
		else {
			return 1+Math.min(minDeletionsRec(x, i+1, j), minDeletionsRec(x, i, j-1));
		}
	}
	
	public static void main(String[] args)
	{
		String X = "ACBCDBAA";

		System.out.print("The minimum number of deletions required are " +
								minDeletions(X));
	}

}
