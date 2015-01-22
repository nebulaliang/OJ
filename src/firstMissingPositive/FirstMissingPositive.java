package firstMissingPositive;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] A) {
		if (A == null || A.length == 0) {
			return 1;
		}

		int n = A.length;
		int i = 0;
		while (i < n) {
			int val = A[i];
			if (val > 0 && val <= n && i + 1 != val && val != A[val - 1]) {
				swap(A, i, val - 1);
			} else {
				i++;
			}
		}

		for (i = 0; i < n; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}
