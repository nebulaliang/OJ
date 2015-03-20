package isPalindrome;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !isAlpha(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAlpha(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private boolean isAlpha(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }

}
