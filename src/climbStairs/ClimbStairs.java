package climbStairs;

public class ClimbStairs {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n==1) return 1;
		if(n==2) return 2;
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i=2;i<n;i++){
        	result[i] = result[i-2]+result[i-1];
        }
        return result[n-1];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(climbStairs(3));
	}

}
