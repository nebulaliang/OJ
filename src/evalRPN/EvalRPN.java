package evalRPN;

import java.util.Stack;

public class EvalRPN {
	/*
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation.
	 * 
	 * Valid operators are +, -, *, /. Each operand may be an integer or another
	 * expression.
	 * 
	 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4",
	 * "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	public int evalRPN(String[] tokens) {
		String ops = "+-*/";
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (String s : tokens) {
			if (!ops.contains(s)) {
				stack.push(new Integer(s));
			} else {
				int index = ops.indexOf(s);
				int op2 = stack.pop();
				int op1 = stack.pop();
				switch (index) {
				case 0:
					result = op1 + op2;
					break;
				case 1:
					result = op1 - op2;
					break;
				case 2:
					result = op1 * op2;
					break;
				case 3:
					result = op1 / op2;
					break;
				}
				stack.push(result);
			}
		}

		return stack.pop();
	}

}
