package countAndSay;

public class CountAndSay {

	public String countAndSay(int n) {
		String res = "1";

		for (int i = 1; i < n; i++) {
			char[] chars = res.toCharArray();
			char cur = chars[0];
			String s = "";
			int count = 1;
			for (int j = 1; j < chars.length; j++) {
				if (cur == chars[j]) {
					count++;
				} else {
					s += count + String.valueOf(cur);
					cur = chars[j];
					count = 1;
				}
			}
			s += count + String.valueOf(cur);
			res = s;
		}

		return res;
	}

}
