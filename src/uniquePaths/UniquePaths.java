package uniquePaths;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 1; i < n; i++) {
            matrix[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            matrix[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }

        return matrix[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int matrix[][] = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            matrix[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                matrix[0][i] = 0;
                break;
            } else {
                matrix[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                matrix[i][0] = 0;
                break;
            } else {
                matrix[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[m - 1][n - 1];
    }
}
