package findMedianSortedArrays;

public class FindMedianSortedArrays {

	public double findMedianSortedArrays(int A[], int B[]) {
		int a_len = A.length;
		int b_len = B.length;
		int total_len = a_len + b_len;
		if (total_len % 2 == 0) {
			return (double) (findkth(A, 0, B, 0, total_len / 2 + 1) + findkth(
					A, 0, B, 0, total_len / 2)) / 2;
		} else {
			return (double) findkth(A, 0, B, 0, total_len / 2 + 1);
		}
	}

	private int findkth(int A[], int a_start, int B[], int b_start, int k) {
		if (a_start >= A.length) {
			return B[b_start + k - 1];
		}
		if (b_start >= B.length) {
			return A[a_start + k - 1];
		}
		if (k == 1) {
			return Math.min(A[a_start], B[b_start]);
		}
		int median = k / 2 - 1;
		int A_key = a_start + median < A.length ? A[a_start + median]
				: Integer.MAX_VALUE;
		int B_key = b_start + median < B.length ? B[b_start + median]
				: Integer.MAX_VALUE;
		if (A_key < B_key) {
			return findkth(A, a_start + k / 2, B, b_start, k - k / 2);
		} else {
			return findkth(A, a_start, B, b_start + k / 2, k - k / 2);
		}
	}

}
