package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String word : strs) {
			char[] word_chars = word.toCharArray();
			Arrays.sort(word_chars);
			String anagram = new String(word_chars);
			if (map.containsKey(anagram)) {
				map.get(anagram).add(word);
			} else {
				List list = new ArrayList<String>();
				list.add(word);
				map.put(anagram, list);
			}
		}

		for (String anagram : map.keySet()) {
			if (map.get(anagram).size() > 1) {
				result.addAll(map.get(anagram));
			}
		}

		return result;
	}

	/*
	 * Given a list of lowercase words with no duplicates, write a function that
	 * prints out all the words in the following format: If a word has anagrams
	 * in the list, print them all in one line separated by spaces in
	 * alphabetical order; otherwise, print the word in a single line. The first
	 * word in each Line should also be printed in alphabetical order.
	 * 
	 * Any word or phrase that exactly reproduces the letters in another order
	 * is an anagram.
	 * 
	 * e.g. "good", "god", "dog", "dag", "tan", "ant" ant tan dag dog god good
	 */
	public static List<List<String>> anaGen(List<String> inputWords) {

		List<List<String>> result = new ArrayList<List<String>>();
		Collections.sort(inputWords);
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String cur : inputWords) {

			char[] array = cur.toCharArray();
			Arrays.sort(array);
			String str = new String(array);
			if (map.containsKey(str)) {
				result.get(map.get(str)).add(cur);
			} else {
				int cnt = result.size();
				map.put(str, cnt);
				List<String> curList = new ArrayList<String>();
				curList.add(cur);
				result.add(curList);
			}
		}
		for (List<String> list : result) {
			System.out.println(list);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<String>();
		strs.add("good");
		strs.add("god");
		strs.add("dog");
		strs.add("dag");
		strs.add("tan");
		strs.add("ant");
		anaGen(strs);
	}
}
