package validParentheses;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * @param args
	 */
	 public boolean isValid(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Stack<String> st = new Stack<String>();
	        for(int i=0;i<s.length();i++){
	        	char c = s.charAt(i);
	        	if(c=='(' || c=='[' || c=='{'){
	        		st.push(Character.toString(c));
	        	}
	        	else{
	        		if(st.empty()) return false;
	        		if(c==')'){
	        			if(!st.peek().equals("(")) return false;
	        			st.pop();
	        		}
	        		else if(c==']'){
	        			if(!st.peek().equals("[")) return false;
	        			st.pop();
	        		}
	        		else{
	        			if(!st.peek().equals("{")) return false;
	        			st.pop();
	        		}
	        	}
	        }
	        if(!st.empty()) return false;
	        return true;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
