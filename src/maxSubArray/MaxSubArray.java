package maxSubArray;

public class MaxSubArray {

    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        
        int min = prefixSum[0];
        int max = prefixSum[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, Math.max(prefixSum[i],prefixSum[i] - min));
            min = Math.min(min, prefixSum[i]);
        }
        
        return max;
    }

}
