package merge;

public class MergeTwoArray {

	/**
	 * @param args
	 */
	public void merge(int A[], int m, int B[], int n) {
		int k=m+n-1;
	       if(m==0) {
	            for(int i=0;i<n;i++){
	                A[i]=B[i];
	            }
	            return;
	        }
	       if(n==0) return;
	        m--;n--;
	        while(m>=0 && n>=0){
	            if(A[m]>B[n]){
	        		A[k] = A[m];
	        		m--;
	        	}
	        	else{
	        		A[k] = B[n];
	        		n--;
	        	}
	        	k--;
	        }
	        if(m<0){
	        	for(;n>=0;n--){
	        		A[k]=B[n];
	        		k--;
	        	}
	        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
