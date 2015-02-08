package minPathSum;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        //init first element
        sum[0][0] = grid[0][0];
        //init first row
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        //init first column
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i][j - 1], sum[i - 1][j]);
            }
        }
        
        return sum[m - 1][n - 1];
    }

}
