package strStr;

public class StrStr {

	/**
	 * @param args
	 */
	public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (needle.length() == 0) {//you can always find an empty string
            return haystack;
        }
        if (haystack.length () < needle.length()) {
            return null;
        }
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return haystack.substring(i - j);
                }
            }
            else {
                i = i - j + 1;
                j = 0;
            }
        }
        return null;
    }
	public String search(String haystack, String needle){
		for(int i=0;i<haystack.length();i++){
			for(int j=0;j<needle.length() && (i+j)<haystack.length();j++){
				if(needle.charAt(j)!=haystack.charAt(i+j)){
					break;
				}
				if(j==needle.length()-1) return haystack.substring(i);
			}
		}
		return null;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12345";
		p(s.substring(2));
	}

}
