package longestCommonPrefix;

public class LongestCommonPrefix {

	/**
	 * @param EASY
	 */
	public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		String result = "";
		int n = strs.length;
		if(n==1) return strs[0];
		if(n<2 || strs[0].equals("")) return result;
		int min_size = Integer.MAX_VALUE;
		int min_index = -1;
		for(int i=0;i<n;i++){
			int length = strs[i].length();
			if(length<min_size){
				min_size = length;
				min_index = i;
			}
		}
		String compared_str = strs[min_index];
		if(compared_str.equals("")) return result;
		int compared_size = compared_str.length();
		for(int i=0;i<compared_size;i++){
			char compared_char = compared_str.charAt(i);
			for(int j=0;j<n;j++){
				if(j==min_index) continue;
				char c = strs[j].charAt(i);
				if(c!=compared_char) return result;
			}
			result+=Character.toString(compared_char);
		}
        return result;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p('c'!='c');
		String[] strs = new String[]{"a","b"};
		p(longestCommonPrefix(strs));
	}

}
