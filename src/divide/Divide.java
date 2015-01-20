package divide;

public class Divide {

	public int divide(int dividend, int divisor) {
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		long result = 0;
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) {
				shift++;
			}
			shift--;
			result += (long) 1 << (shift);
			a -= b << (shift);
		}
		result *= sign;
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return (int) result;
	}

}
