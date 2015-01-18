package candy;

public class Candy {

	// idea: go through the array two times.
	// First time, from left to right; second time, from right to left.
	public static int candy(int[] ratings) {
		if (ratings == null) {
			return 0;
		}

		int len = ratings.length;
		int[] assign = new int[len];
		// left to right
		for (int i = 1; i < len; i++) {
			if (ratings[i] > ratings[i - 1]) {
				assign[i] = assign[i - 1] + 1;
			}
		}
		// right to left
		for (int i = len - 2; i >= 0; i--) {
			//don't neglect the second condition.
			if (ratings[i] > ratings[i + 1] && assign[i] <= assign[i + 1]) {
				assign[i] = assign[i + 1] + 1;
			}
		}
		// get the total
		int result = len;
		for (int i = 0; i < len; i++) {
			result += assign[i];
		}

		return result;
	}
}
