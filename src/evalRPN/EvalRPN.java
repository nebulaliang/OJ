package evalRPN;
import java.util.Stack; 
public class EvalRPN {

	/**
	 * @param args
	 */
//	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//	Some examples:
//	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	
	//基本思路：使用栈来存放历史数据。每遇到运算符，从栈中取出两个数进行运算，将结果push入栈中。注意运算顺序。
	//代码可以精简：String operators = "+-*/";!operators.contains(t)
	public int evalRPN(String[] tokens) {
        Stack<Integer> sk = new Stack<Integer>(); 
        int first,second;
        for(String s:tokens){
            if(s.equals("+")){
            	second = sk.pop();
            	first = sk.pop();
            	sk.push(first+second);
            }
            else if(s.equals("-")){
            	second = sk.pop();
            	first = sk.pop();
            	sk.push(first-second);
            }
            else if(s.equals("*")){
            	second = sk.pop();
            	first = sk.pop();
            	sk.push(first*second);
            }
            else if(s.equals("/")){
            	second = sk.pop();
            	first = sk.pop();
            	sk.push(first/second);
            }
            else{
            	sk.push(Integer.valueOf(s));
            }
        }
        return sk.pop();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
