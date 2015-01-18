package addBinary;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void p(Object o) {
		System.out.println(o);
	}


	public static String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}

		if (b == null || b.length() == 0) {
			return a;
		}

		StringBuilder sb = new StringBuilder();

		int lastA = a.length() - 1;
		int lastB = b.length() - 1;
		int carry = 0;

		while (lastA >= 0 || lastB >= 0 || carry > 0) {
			int num1 = lastA >= 0 ? a.charAt(lastA--) - '0' : 0;
			int num2 = lastB >= 0 ? b.charAt(lastB--) - '0' : 0;
			int current = (num1 + num2 + carry) % 2;
			carry = (num1 + num2 + carry) / 2;

			sb.insert(0, current);

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String a = "123";
		char[] a_char = a.toCharArray();
		p(addBinary("11", "100"));
	}

}
