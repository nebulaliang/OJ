package singleNumber;

public class SingleNumber {

	/**
	 * @param args
	 */
	public int singleNumber(int[] A) {
		int x=0;
        for(int a: A){
            x = x ^ a;
        }
        return x;
    }
	
	private static void p(Object o){
		System.out.println(o);
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=0;
		p(0^10);
	}

}
