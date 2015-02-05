package lengthOfLastWord;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s.equals("")) {
            return 0;
        }

        int n = s.length();
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count != 0) {
                    return count;
                }
            }
        }
        return count;
    }

}
