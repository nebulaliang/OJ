package containerWithMostWater;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        /*
         * The area depends on the smaller edge * the width.
         * So, only move the smaller one, we have the chance of increasing the area
         */
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max, area);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}
