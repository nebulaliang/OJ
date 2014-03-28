package isInterleave;

public class IsInterleave {

	/**
	 * @param args
	 */
	 public static boolean isInterleave(String s1, String s2, String s3) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int n1 = s1.length();
	        int n2 = s2.length();
	        int n3 = s3.length();
	        if(n1==0) return s2.equals(s3);
	        if(n2==0) return s1.equals(s3);
	        if(n3!=n1+n2) return false;
	        boolean M[][] = new boolean[n1+1][n2+1];
	        M[0][0] = true;
	        //init first column(for s1)
	        for(int i=1;i<=n1;i++){
	        	M[i][0] = M[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
	        }
	        //init first line(for s2)
	        for(int i=1;i<=n2;i++){
	        	M[0][i] = M[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1);
	        }
	        for(int i=1;i<=n1;i++){
	        	for(int j=1;j<=n2;j++){
	        		if(M[i-1][j]==true){
	        			if(s1.charAt(i-1)==s3.charAt(i+j-1)) M[i][j]=true;
	        		}
	        		else if(M[i][j-1]==true){
	        			if(s2.charAt(j-1)==s3.charAt(i+j-1)) M[i][j]=true;
	        		}
	        		else if(M[i-1][j-1]==true){
	        			if(s1.charAt(i-1)==s3.charAt(i+j-2) && s2.charAt(j-1)==s3.charAt(i+j-1)) M[i][j]=true;
	        			if(s2.charAt(j-1)==s3.charAt(i+j-2) && s1.charAt(i-1)==s3.charAt(i+j-1)) M[i][j]=true;
	        		}
	        		else{
	        			M[i][j]=false;
	        		}
	        	}
	        }
	        return M[n1][n2];
	    }
	 public static void p(Object o){
			System.out.println(o);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isInterleave("a", "b", "ab");
	}

}
