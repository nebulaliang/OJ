package scrambleString;

public class ScrambleString {

	/**
	 * @param args
	 */
	public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s1.length()!=s2.length()) return false;
		int n = s1.length();
		if(n==0) return true;
		if(n==1) return s1.equals(s2);
		for(int i=1;i<=n/2;i++){
			String x1 = s1.substring(0, i);
			String x2 = s1.substring(i);
			String x3 = s1.substring(0,n-i);
			String x4 = s1.substring(n-i);
			
			String y1 = s2.substring(0,i);
			String y2 = s2.substring(i);
			String y3 = s2.substring(0,n-i);
			String y4 = s2.substring(n-i);
			
			if(isScramble(x1,y1) && isScramble(x2,y2)) return true;
			if(isScramble(x1,y4) && isScramble(x2,y3)) return true;
			if(isScramble(x4,y1) && isScramble(x3,y2)) return true;
			if(isScramble(x4,y4) && isScramble(x3,y3)) return true;
//			String x1 = s1.substring(0, i), y1 = s1.substring(n-i), //y1 is x4
//			x2 = s2.substring(0, i), y2 = s2.substring(n-i);   x2 is y1,y2 is y4, a1 is x2,b1 is x3
//            String a1 = s1.substring(i), b1 = s1.substring(0, n-i),   a2 is y2 , b2 is y3
//            a2 = s2.substring(i), b2 = s2.substring(0, n-i);
// 
//            boolean r1 = isScramble(x1, x2) && isScramble(a1, a2);  x1,y1   x2 y2
//            if (r1) return true;
//            boolean r2 = isScramble(x1, y2) && isScramble(a1, b2);  x1,y4    x2,y3
//            if (r2) return true;
//            boolean r3 = isScramble(y1, x2) && isScramble(b1, a2);   x4,y1   x3,y2
//            if (r3) return true;
//            boolean r4 = isScramble(y1, y2) && isScramble(b1, b2);   x4,y4   x3,y3
//            if (r4) return true;
		}
		return false;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "12345";
		String x1 = s1.substring(0, 1);
		String x2 = s1.substring(1);
		p(x1);p(x2);
	}

}
