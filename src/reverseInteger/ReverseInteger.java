package reverseInteger;

public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(reverse2(1000000003));
		p(new String(new char[]{'a','b','c'}));
	}
	public static void p(Object o){
		System.out.println(o);
	}
	
	//version 1. Can not hanlde with overflow problem
	public static int reverse(int x) {
	       int result = 0;
	       int lastDigit = 0;
	       while(x!=0){
	    	   lastDigit = x%10;
	    	   result = result*10 + lastDigit;
	    	   x/=10;
	       }
	       return result;
    }
	//version 2. This version can handle with the overflow problem.
	//basic idea: get the last digit one by one and generate the result one by one
	//            reversely. This can handle the problem that last digit is 0
	//W
	public static int reverse2(int x) {
	       int result = 0;
	       int lastDigit = 0;
	       boolean inNeg = x>0? false:true;
	       x = Math.abs(x);
	       while(x!=0){
	    	   lastDigit = x%10;
	    	   result = result*10 + lastDigit;
	    	   x/=10;
	       }
	       if(result<0) return -1;
	       result = inNeg? -result:result;
	       return result;
 }

}
