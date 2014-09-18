package zigZagConversion;

public class ZigZagConversion {

	/**
	 * @param args
	 */
	public static String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
        int len = s.length();
//        if(len==0) return "";
        if(nRows<=1) return s;
        int n = len/(nRows*2-2);
        int extra = 0;
        if(len%(nRows*2-2)>0){
        	extra = len%(nRows*2-2)>nRows?2:1;
        }
        n=n*2+extra;
        char[][] m = new char[nRows][n];
        StringBuffer result = new StringBuffer();
        int k = 0;
        	for(int i=0;i<nRows;i++){
        		for(int j=0;j<n;j++){
        			if(j%2==1 && (i==0 || i==nRows-1)) continue;
        			if(j%2==0){
        				int index = i+(nRows*2-2)*((j+1)/2);
        				if(index<len){
        				m[i][j] = s.charAt(index);
        				result.append(m[i][j]);
        				}
        			}
        			else{
        				int index = (nRows*2-2)*((j+1)/2)-(nRows-2)+(nRows-1-i)-1;
        				if(index<len){
        				m[i][j] = s.charAt(index);
        				result.append(m[i][j]);
        				}
        			}
        		}
        	}
        return result.toString();
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		p(convert("abcdefghigklmn",3));
		p(convert("PAYPALISHIRING", 4));
//		p(convert("abcdefghigklmn",5));
//		p(convert("PAYPALISHIRING", 3));
		p("PINALSIGYAHRPI".equals("PINALSIGYAHRPI"));
		p(convert("AB", 1));
	}

}
