package longestValidParentheses;
import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	//)(((((()())()()))()(()))(
	public static int longestValidParentheses(String s) {
        int n = s.length();
        int current_max = 0;
        int len = 0;
        int last_len = 0;
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<n;i++){
        	char c = s.charAt(i);
        	if(c=='('){
        		stack.push("(");
        	}
        	else{
        		if(stack.empty()){
        			current_max=Math.max(current_max, last_len);
        			len=0;
        			last_len=0;
        			continue;
        		}
        		stack.pop();
        		len+=2;
        		if(stack.empty()){
        			last_len+=len;
        			len=0;
        			current_max=Math.max(current_max, last_len);
        		}
        	}
        }
        current_max=Math.max(current_max, last_len);
        current_max=Math.max(current_max, len);
        return current_max;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(longestValidParentheses(")(((((()())()()))()(()))("));
	
			p(longestValidParentheses(")))(()(((((()("));	
	}

}
