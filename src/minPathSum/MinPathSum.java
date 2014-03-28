package minPathSum;

public class MinPathSum {

	/**
	 * @param args
	 */
	public static int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        int n = grid[0].length;
        int result[][] = new int[m][n];
        //initial the top left element
        result[0][0] = grid[0][0];
        //initial first column
        for(int i=1;i<m;i++){
        	result[i][0] = result[i-1][0]+grid[i][0];
        }
        //initial first line
        for(int i=1;i<n;i++){
        	result[0][i] = result[0][i-1]+grid[0][i];
        }
        for(int i=1;i<m;i++){
        	for(int j=1;j<n;j++){
        		result[i][j] = grid[i][j]+Math.min(result[i][j-1], result[i-1][j]);
        	}
        }
        return result[m-1][n-1];
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[2][3];
		//grid[0][0]=-1;
		grid[0] = new int[]{1,2,3};
		grid[1] = new int[]{4,5,6};
		p(minPathSum(grid));
		
		//p(grid[0][0]);
	}

}
