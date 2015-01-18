package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
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

}
