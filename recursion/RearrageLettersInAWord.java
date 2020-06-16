package programming.recursion;

import java.util.ArrayList;
import java.util.List;

public class RearrageLettersInAWord {
	
	public static void rearrange_and_print(String word, String rearranged,  int stringLength) {
		
		if (rearranged.length() == stringLength) {
			System.out.println(rearranged);
			return;
		}
		
		for (int c=0; c< word.length(); c++) {
			
			String nextModifiedWord = word.substring(0, c)+word.substring(c+1); //exclude c'th character and send it to recursion
			rearrange_and_print(nextModifiedWord, rearranged+word.charAt(c), stringLength);
		}	
	}
	
	public static void rearrange_store_in_list(String word, String rearranged, List<String> holder, int stringLength) {
		
		if (rearranged.length() == stringLength) {
			holder.add(rearranged);
			return;
		}
		
		for (int c=0; c< word.length(); c++) {
			
			String nextModifiedWord = word.substring(0, c)+word.substring(c+1); //exclude c'th character and send it to recursion
			rearrange_store_in_list(nextModifiedWord, rearranged+word.charAt(c), holder, stringLength);
		}	
	}
	
	public static void main(String[] args) {
		
		String myword = "abcd";
		rearrange_and_print(myword, "", myword.length());
		System.out.println("---------------------------------");
		List<String> holder = new ArrayList<String>(); 
		rearrange_store_in_list(myword, "", holder, myword.length());
		System.out.println(holder.size());
		System.out.println(holder);
	}

}
