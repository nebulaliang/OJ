package rotateImage;

public class RotateImage {

	/**
	 * @param args
	 */
	//  Rotate Image(leetcede 88)
	//	You are given an n x n 2D matrix representing an image.
	//
	//	Rotate the image by 90 degrees (clockwise).
	//
	//	Follow up:
	//	Could you do this in-place?
	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        
		for(int i=0;i<n/2;i++){
        	for(int j=0;j<n/2;j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[n-1-j][i];
        		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        		matrix[j][n-1-i] = temp;
        	}
        }
		if(n%2==0){
			int i=n/2;int j=n/2;
			int temp = matrix[i][j];
    		matrix[i][j] = matrix[n-1-j][i];
    		matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
    		matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
    		matrix[j][n-1-i] = temp;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
