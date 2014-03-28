package plusOne;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PlusOne {

	/**
	 * @param args
	 */
	public static int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n+1]; 
        int carry = 1;
        int i = n-1;
        int j=i+1;
        while(i>=0){
        int add = digits[i]+carry;
        result[j] = add%10;
        carry = add/10;
        i--;j--;
        }
        if(carry==0) {
        	return Arrays.copyOfRange(result, 1, n+1);
        }
        result[0]=carry;
        return result;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{1,2,3};
		int[] x = plusOne(num);
		//p(x[0]);p(x[1]);p(x[2]);
	}

}
