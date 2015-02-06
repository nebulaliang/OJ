package longestPalindrome;

public class LongestPalindrome {

    // MEDIUM HARD(the key is to find DP transform rule)
    // BASIC IDEA: check whether the inner substring is palindrome; together
    // with the first
    // and last letters, we can judge whether the current string is palindrome.
    // Use DP to store previous result.
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] p = new boolean[n][n];
        int startIndex = 0;
        int maxLen = 1;
        // initialize the slant from upleft to bottomright.
        // The single letter can be counted as Palindrome.
        for (int i = 0; i < n; i++) {
            p[i][i] = true;
        }
        // initialize the second slant
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                p[i][i + 1] = true;
                startIndex = i;
                maxLen = 2;
            }
        }
        // Apply DP formula.
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (p[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    // a1a2a3a4.....an-1an. p[i+1][j-1] is check whether
                    // a2..an-2 is palindrome
                    // p[i+1][j-1] is left bottom corner of p[i][j]
                    p[i][j] = true;
                    startIndex = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

}
