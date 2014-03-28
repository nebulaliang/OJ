package numDistinct;
import print.Print;;
public class NumDistinct {

	/**
	 * @param args
	 */
	public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S.length()<T.length()) return 0;
        if(S.length()==T.length()) return S.equals(T)?1:0;
        int[][] M = new int[T.length()][S.length()];
        char[] ss = S.toCharArray();
        char[] ts = T.toCharArray();
        //init first element
        if(ss[0]==ts[0]) M[0][0]=1;
        //init first line
        for(int i=1;i<S.length();i++){
        	if(ss[i]==ts[0]){
        		M[0][i]=M[0][i-1]+1;
        	}
        	else{
        		M[0][i]=M[0][i-1];
        	}
        }
        for(int i=1;i<T.length();i++){
        	for(int j=1;j<S.length();j++){
        		if(ss[j]==ts[i]){
        			M[i][j]=M[i-1][j-1]+M[i][j-1];
        		}
        		else{
        			M[i][j]=M[i][j-1];
        		}
        	}
        }
        return M[T.length()-1][S.length()-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[5];
		Print.p(x[2]);
	}

}
