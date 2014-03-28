package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (strs.length<2) return new ArrayList<String>();
		HashMap<String,ArrayList<String>> map = new HashMap();
		for(String str: strs){
			String key = sort_str(str);
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<String>());
			}
			ArrayList<String> temp = map.get(key);
			temp.add(str);
		}
		ArrayList<String> result = new ArrayList<String>();
		for(String key: map.keySet()){
			ArrayList<String> temp = map.get(key);
			if(temp.size()>1){
				result.addAll(temp);
			}
		}
		
        return result;
    }
	public static String sort_str(String str){
		char[] str_chars = str.toCharArray();
		Arrays.sort(str_chars);
		return new String(str_chars);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "cba";
		char[] a_char = a.toCharArray();
		 Arrays.sort(a_char);
		 p(new String(a_char));
		 String[] strs = new String[]{"cba","abc","abd"};
		 Arrays.sort(strs);
		 p(strs[1]);
	}

}
