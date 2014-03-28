package setZeroes;

public class SetZeroes {

	/**
	 * @param args
	 */
	//EASY
	//only one thing need to note: we can not replace any element at the first traverse
	//because it would effect the following result.
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] line = new boolean[m];
		boolean[] col = new boolean[n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(matrix[i][j]==0){
        			line[i] = true;
        			col[j] = true;
        		}
        	}
        }
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(line[i] || col[j]){
        			matrix[i][j]=0;
        		}
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
