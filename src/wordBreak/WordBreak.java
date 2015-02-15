package wordBreak;

import java.util.Set;

public class WordBreak {

    // method 1: iterate input string
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int len = 1; len <= n - i; len++) {
                String word = s.substring(i, i + len);
                if (dp[i] && dict.contains(word)) {
                    dp[i + len] = true;
                }
            }
        }
        return dp[n];
    }
    
    //method 2: iterate dictionary
    public boolean wordBreak2(String s, Set<String> dict) {
        int n = s.length();
        boolean[] b = new boolean[n + 1];
        b[0] = true;
        
        for(int i = 0; i < n; i++){
            if(!b[i]){
                continue;
            }
            for(String word : dict){
                int len = word.length();
                if(i + len > n) continue;
                if(s.substring(i , i + len).equals(word)){
                    b[i + len] = true;
                }
            }
        }
        
        return b[n];
    }
}
