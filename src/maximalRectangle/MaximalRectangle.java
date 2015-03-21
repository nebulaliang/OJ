package maximalRectangle;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] compute = new int[n];
        for (int i = 0; i < n; i++) {
                compute[i] = matrix[0][i] - '0';
        }
        int max = largestRectangleArea(compute);
        for (int i = 1; i < m; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < n; j++) {
                compute[j] = matrix[i][j] == '0' ? 0 : row[j] - '0' + compute[j];
            }
            max = Math.max(max, largestRectangleArea(compute));
        }
        
        return max;
    }
    
    private int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int n = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0;  i <= n; i++) {
            int cur_height = i == n ? -1 : height[i];
            //pop all element higher than curent height,
            //compute each area and get curent max area
            while (!stack.isEmpty() && cur_height < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1; 
                max = Math.max(max, h * w);
            }
            //each element will be pushed into stack once
            stack.push(i);
        }
        
        return max;
    }

}
