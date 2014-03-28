package findMedianSortedArrays;

public class FindMedianSortedArrays {

	/**
	 * @param args
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
        int m = A.length;
        int n = B.length; 
        if(m==0 || n==0) return 0;
        if(A[m-1]<=B[0]){
        	if(m==n) return (double)A[m-1];
        	else if(m>n) return (double)A[(m+n)/2];
        	else{
        		return (double)B[(m+n)/2-m];
        	}
        }
        else{
        	return 0;
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
