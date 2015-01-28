package merge;

public class MergeTwoArray {

    public void merge(int A[], int m, int B[], int n) {
        int k = m + n - 1;
        int a = m - 1;
        int b = n - 1;
        while (a >= 0 && b >= 0) {
            if (A[a] > B[b]) {
                A[k--] = A[a--];
            } else {
                A[k--] = B[b--];
            }
        }

        if (b >= 0) {
            while (k >= 0) {
                A[k--] = B[b--];
            }
        }
    }

}
