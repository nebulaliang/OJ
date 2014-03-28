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
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3,5};
		p(firstMissingPositive(A));
	}

}
