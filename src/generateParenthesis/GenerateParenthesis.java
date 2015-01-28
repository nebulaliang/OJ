package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		if (n == 0) {
			return res;
		}

		dfs(res, "", n, n);
		return res;
	}

	private void dfs(List<String> res, String temp, int left, int right) {
		if (left == 0 & right == 0) {
			res.add(temp);
			return;
		}
		if (left > 0) {
			dfs(res, temp + "(", left - 1, right);

		}
		if (left < right) {
			dfs(res, temp + ")", left, right - 1);
		}

	}

}
