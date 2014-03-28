package lengthOfLongestSubstring;

import java.util.HashMap;

public class LengthOfLongestSubstring {

	/**
	 * @param args
	 */
	// "abcabcbb" is "abc"
	public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int n = s.length();
        int length = 0;
        int temp_length = 0;
        for(int i=0;i<n;i++){
        	String s_i = Character.toString(s.charAt(i));
        	if(map.containsKey(s_i)){
        		//clear up the map, set i to next of map.get(s_i)
        		int index = map.get(s_i).intValue();
        		i = index;
        		length = Math.max(length,temp_length);
        		temp_length = 0;
        		map.clear();
        	}
        	else{
        		map.put(s_i, i);
        		temp_length+=1;
        		length = Math.max(length,temp_length);
        	}
        }
        return length;
    }
	 public static void p(Object o){
			System.out.println(o);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
