package maxSubArray;

public class MaxSubArray {

	/**
	 * @param args
	 */
	// O(n) method
	public static int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int max_element = Integer.MIN_VALUE;
        int i=0;
        for(;i<n;i++){
        	int element = A[i];
        	max_element = Math.max(max_element, element);
        	if(A[i]>=0){i++;break;}
        }
        if(i==n) return max_element;
        i--;
        int max=A[i];
        int sum=0;
        for(;i<n;i++){
        	int e = A[i];
        	if(e<=0) {sum+=e;}
        	else{
        		if(sum>=0){
        			sum+=e;
        			max = Math.max(max, sum);
        		}
        		else{
        			sum+=e;
        			max = Math.max(max, e);
        			sum=0;
        			i--;
        		}
        	}
        }
        return max;
    }
	public static int maxSubArray1(int[] A){
		return 0;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2};
		p(maxSubArray(a));
	}

}
