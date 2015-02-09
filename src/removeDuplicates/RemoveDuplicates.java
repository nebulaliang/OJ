package removeDuplicates;

public class RemoveDuplicates {

    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int cur = A[i];

        while (j < len) {
            if (A[j] == cur) {
                j++;
            } else {
                A[++i] = A[j];
                cur = A[j];
            }
        }

        return i + 1;
    }

    public int removeDuplicates2(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        int cur = A[i];
        boolean duplicate = false;
        while (j < len) {
            if (A[j] == cur && !duplicate) {
                A[++i] = A[j];
                duplicate = true;
            } else if (A[j] != cur) {
                A[++i] = A[j];
                cur = A[i];
                duplicate = false;
            }
            j++;
        }

        return i + 1;
    }

}
