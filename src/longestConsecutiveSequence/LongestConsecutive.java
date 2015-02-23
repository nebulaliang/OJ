package longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : num) {
            set.add(x);
        }

        int max = 0;
        for (int x : num) {
            int count = 1;
            int left = x - 1;
            int right = x + 1;
            //if contais left or right, keep searching.
            while (set.contains(left)) {
                count++;
                set.remove(left--);
            }
            while (set.contains(right)) {
                count++;
                set.remove(right++);
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
