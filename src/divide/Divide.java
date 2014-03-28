package divide;

public class Divide {

	/**
	 * @param args
	 */
	 public static int divide1(int dividend, int divisor) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int result = 0;
	        if(dividend<divisor || dividend==0) return 0;
	        boolean ispositive=true;
	        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        	ispositive=true;
	        }
	        else{
	        	ispositive=false;
	        }
	        dividend = Math.abs(dividend);
	        divisor = Math.abs(divisor);
	        if(dividend==divisor) return 1;
	        while(dividend>=divisor){
	        	dividend-=divisor;
	        	result++;
	        }
	        if(ispositive){
	        return result;
	        }
	        else{
	        	return 0-result;
	        }
	    }
	 
	 public static int divide2(int dividend, int divisor) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int result = 0;
	        if( dividend==0) return 0;
	        boolean ispositive=true;
	        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
	        	ispositive=true;
	        }
	        else{
	        	ispositive=false;
	        }
	        long dividend1 = Math.abs(dividend);
	        long divisor1 = Math.abs(divisor);
	        if(dividend1==divisor1){ result= 1;
	        if(ispositive){
		        return result;
		        }
		        else{
		        	return 0-result;
		        }}
	        long base = divisor1;
	        while(dividend1>=divisor1){
	        	base = divisor1;
	        	int count = 0;
	        	while(dividend1>(base<<1)){
	        		base<<=1;
	        		count++;
	        	}
	        	result+=(1<<count);
	        	dividend1-=base;
	        }
	        if(ispositive){
	        return result;
	        }
	        else{
	        	return 0-result;
	        }
	    }
	 
	 public static int divide(int dividend, int divisor) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 //http://tianrunhe.wordpress.com/2012/07/14/division-without-using-or-divide-two-integers/
	        if(divisor == 0)
	            return 0;
	        if(divisor == 1)
	            return dividend;
	        if(dividend == divisor)
	            return 1;
	        if(divisor == 2)
	            return dividend >> 1;
	            
	        boolean sign = false;
	        if( (dividend > 0 && divisor < 0) ||
	            (dividend < 0 && divisor > 0) )
	            sign = true;
	            
	        if(dividend == Integer.MAX_VALUE && divisor == Integer.MIN_VALUE)
	            return 0;
	        
	        dividend = dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(dividend);
	        divisor = divisor == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(divisor);
	        int result = (int) Math.floor(Math.pow(Math.E, Math.log(dividend) - Math.log(divisor)));
	        return sign ? -result : result;
	    }
	 public static void p(Object o){
			System.out.println(o);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p(divide(-1,1));
		int a=2;
		a=a<<2;
		p(a);
	}

}
