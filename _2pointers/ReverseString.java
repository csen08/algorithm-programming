package programming._2pointers;

public class ReverseString {
	
	public static void reverse(String s) {
		//Strategy is convert string to char array and swap
		char[] chars = s.toCharArray();//string is immutable, so creating new sets
		int length =chars.length;
		// two pointers,at both ends, swap values until pointers cross each other
		int j=length-1;
		for (int i=0;i<j;i++) // i<length check not required
		{
			//if (i<j) {
				char t = chars[i];
				chars[i]=chars[j];
				chars[j]=t;
			//}
			System.out.println(j);
			j--;
		}
		System.out.println(String.valueOf(chars));
	}
	
	
	public static void reverse_improved(String s) {
	//Strategy is convert string to char array and swap
	char[] chars = s.toCharArray();
	//string is immutable, so creating char array that is mutable
	
	// two pointers,at both ends, swap values until pointers cross each other
	int i=0;
	int j=chars.length-1;
	
	while (i<=j) {
		char c = chars[i];
		chars[i] = chars[j];
		chars[j] = c;
		i++;
		j--;
	}
	System.out.println(new String(chars));
}
	
	public static void main(String[] args) {
		
		//String input = "this is a string";
		String input = "this";
		reverse(input);
		
		reverse_improved("Hello world");
	}

}
