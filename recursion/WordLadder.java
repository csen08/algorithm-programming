package programming.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	/**
	 * save the word-path, print the length Input: Dictionary = {POON, PLEE, SAME,
	 * POIE, PLEA, PLIE, POIN} start = TOON target = PLEA
	 */

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> s = new HashSet<String>();
		for (String word : wordList)
			s.add(word);

		if (!s.contains(endWord))
			return 0;

		Queue<String> queue = new ArrayDeque<String>();
		int level = 1;

		queue.offer(beginWord);

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int k = 0; k < size; k++) {
				String current_word = queue.poll();
				// break it
				char[] word_chars = current_word.toCharArray();
				// for each character
				for (int i = 0; i < word_chars.length; i++) {
					char original_char = word_chars[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (word_chars[i] == c)
							continue;
						word_chars[i] = c;
						String new_word = String.valueOf(word_chars);
						if (new_word.equals(endWord))
							return level + 1;// plus 1 because startWord is included
						if (s.contains(new_word)) {
							s.remove(new_word);
							queue.offer(new_word);
							// level++; -> level cannot be increase here, as queue can hold more than one
							// element in a particular level
						}
					}
					word_chars[i] = original_char;
				}
			}
			level++; // increase here, after poll completed at a certain level
		}
		return 0;
	}

	public static void main(String[] args) {

		Set<String> s = new HashSet<>();
		// Dictionary = {POON, PLEE, SAME, POIE, PLEA, PLIE, POIN}
		s.add("POON");
		s.add("PLEE");
		s.add("SAME");
		s.add("POIE");
		s.add("PLEA");
		s.add("PLIE");
		s.add("POIN");
		// POON>POIN>POIE>PLIE>PLEE>PLEA

//		wordLadder(s, "TOON", "PLEA");

		List<String> l = new ArrayList<String>();
		l.add("hot");
		l.add("dot");
		l.add("dog");
		l.add("lot");
		l.add("log");
		l.add("cog");
		System.out.println(ladderLength("hit", "cog", l));

	}

}
