package validParentheses;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < n; i++) {
            char c = chars[i];
            if(c == ')' || c == ']' || c == '}')  {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char first = stack.peek().charValue();
                    if( (c == ')' && (first == '[' || first == '{')) ||
                        (c == ']' && (first == '(' || first == '{')) ||
                        (c == '}' && (first == '[' || first == '('))
                        ) {
                            return false;
                        } else {
                            stack.pop();
                        }
                }
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }

}
