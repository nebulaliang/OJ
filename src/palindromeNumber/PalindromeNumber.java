package palindromeNumber;

public class PalindromeNumber {

	/**
	 * @param args
	 */
	public static boolean isPalindrome(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(x<0) return false;
	        if(x==0) return true;
	        int div = 1;
	        //there easy to make mistake of 'x/div>10'; 
	        //when second high digit is 0, the bug happens.
	        while(x/div>=10){
	        	div*=10;
	        }
	        p(div);
	        while(x!=0){
	        	//check whether the first digit equals the last digit
	        	int r = x%10;
	        	int l = x/div;
	        	if(l!=r) return false;
	        	//truncate the first digit and last digit
	        	x = (x%div)/10;
	        	p(x);
	        	div/=100;
	        }
	        return true;
	    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isPalindrome(110001);
	}

}
