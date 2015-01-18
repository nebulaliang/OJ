package climbStairs;

public class ClimbStairs {
	
	public int climbStairs(int n) {
		// f(n) = f(n-1) + f(n-2)
		// we need to consider the special situation of n=1 and n=2.
		// f(1)=1;f(2)=2;
		int[] a = new int[] { 1, 2 };
		if (n <= 2) {
			return a[n - 1];
		}

		for (int i = 3; i <= n; i++) {
			a[(i - 1) % 2] = a[0] + a[1];
		}

		return a[(n - 1) % 2];
	}

}
