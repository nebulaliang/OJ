package spiralOrder;

import java.util.ArrayList;

public class SpiralOrder {

	//	Spiral Matrix(leetcode 100)
	//	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	//
	//	For example,
	//	Given the following matrix:
	//
	//	[
	//	 [ 1, 2, 3 ],
	//	 [ 4, 5, 6 ],
	//	 [ 7, 8, 9 ]
	//	]
	//	You should return [1,2,3,6,9,8,7,4,5].
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		int i, k = 0, l = 0;
		 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
		ArrayList<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;
        if(m==0) return result;
        int n = matrix[0].length;
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	            result.add(new Integer(matrix[k][i]));
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	        	result.add(new Integer(matrix[i][n-1]));
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	            	result.add(new Integer(matrix[m-1][i]));
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	            	result.add(new Integer(matrix[i][l]));
	            }
	            l++;    
	        }        
	    }
	    return result;
    }
	//	Spiral Matrix II(leetcode 101)
	//	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	//
	//	For example,
	//	Given n = 3,
	//
	//	You should return the following matrix:
	//	[
	//	 [ 1, 2, 3 ],
	//	 [ 8, 9, 4 ],
	//	 [ 7, 6, 5 ]
	//	]
	public int[][] generateMatrix(int n) {
		int i, k = 0, l = 0;
		 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
		int[][] matrix = new int[n][n]; 
        if(n==0) return matrix;
        int m=n;
        int count = 0;
	    while (k < m && l < n)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = l; i < n; ++i)
	        {
	        	count++;
	        	matrix[k][i]=count;
	        }
	        k++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = k; i < m; ++i)
	        {
	        	count++;
	        	matrix[i][n-1]=count;
	        }
	        n--;
	 
	        /* Print the last row from the remaining rows */
	        if ( k < m)
	        {
	            for (i = n-1; i >= l; --i)
	            {
	            	count++;
	            	matrix[m-1][i]=count;
	            }
	            m--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (l < n)
	        {
	            for (i = m-1; i >= k; --i)
	            {
	            	count++;
	            	matrix[i][l]=count;
	            }
	            l++;    
	        }        
	    }
	    return matrix;
    }

}
