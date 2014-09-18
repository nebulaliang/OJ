package firstMissingPositive;

public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] a = new int[A.length+1];
        for(int i=0;i<A.length;i++){
        	int value = A[i];
        	if(value>0 && value<a.length) a[value]=value;
        }
        for(int i=1;i<a.length;i++){
        	if(a[i]!=i) return i;
        }
        return a.length;
    }
	
	
	public static int firstMissingPositive1(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int taken;
        for(int i=0;i<n;i++){
        	taken = A[i];
        	while(taken>0){
        		if(taken>=n){
        			A[i] = -1;
        			break;
        		}
        		int replace_i = taken;
        		taken = A[taken];
        		A[replace_i] = replace_i;
        		A[i] = -1;
        	}
        }
        for(int i=1;i<n;i++){
        	if(A[i]==-1)
        		return i;
        }
        return 1;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3,5};
		p(firstMissingPositive(A));
	}

}
