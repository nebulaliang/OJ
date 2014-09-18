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
		//This method take O(n) space, it is not beeter than the below one.
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
	
	public int climbStairs1(int n) {
		//f(n) = f(n-1)+f(n-2)
		//we need to consider the special situation of n=1 and n=2.
		//f(1)=1;f(2)=2;
        int[] a = {1,2};
        if(n<=2) return a[n-1];
        int i = 1;
        while(n>2){
            i = (i+1)%2;
            a[i] = a[0]+a[1];
            n--;
        }
        return a[i];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(climbStairs(1));
	}

}
