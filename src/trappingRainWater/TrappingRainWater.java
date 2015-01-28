package trappingRainWater;

public class TrappingRainWater {
    /*
     * Basic Idea: Each bar has two value of maximum: one is the maximum on its
     * left; the other one is the maximum on it right; The water this bar can
     * contain is the minimum one of left and right maximum minus its own
     * height.
     */
    public int trap(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int n = A.length;
        int max = Integer.MIN_VALUE;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = Math.max(max, A[i]);
            max = left[i];
        }
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = Math.max(max, A[i]);
            max = right[i];
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(left[i], right[i]) - A[i];
        }
        return total;
    }
}
