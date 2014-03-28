package pow;

public class Pow {

	/**
	 * @param args
	 */
	public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		boolean neg = false;
        if(n==0) return 1;
        if(n<0) neg = true;
        n = Math.abs(n);
        double value = x;
        for(int i=1;i<n;i++){
        	value*=x;
        }
        if(neg) return 1/value;
        return value;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
