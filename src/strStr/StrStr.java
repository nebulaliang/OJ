package strStr;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        
        int h_len = haystack.length();
        int n_len = needle.length();
        
        for (int i = 0; i < h_len - n_len + 1; i++) {
            int j = 0;
            for (; j < n_len; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if(j == n_len) {
                return i;
            }
        }
        
        return -1;
    }

}
