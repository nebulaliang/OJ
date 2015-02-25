package romanInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        char last = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            // consider the situation that last is I, X, or C 
            // and next is larger than it
            if (map.get(last) < map.get(cur)) {
                result -= map.get(last);
            } else {
                result += map.get(last);
            }
            last = cur;
        }
        result += map.get(last);

        return result;
    }

    public String intToRoman(int num) {
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                ret.append(symbols[i]);
                num -= values[i];
            }
        }
        return new String(ret);
    }
}
