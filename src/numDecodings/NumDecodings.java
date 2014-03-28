package numDecodings;

import java.util.Arrays;

public class NumDecodings {

	/**
	 * @param args
	 */
	public static int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s=="") return 0;
        char[] s_chars = s.toCharArray();
        if(s_chars[0]=='0') {return 0;}
        if(s_chars.length==1){return 1;}
        else{
        	//p(s_chars[0]=='1');
        if(s_chars[0]=='0') {return 0;}
        else if(s_chars[0]=='1'){
        	if(s_chars[1]=='0'){
        		if(s_chars.length==2) return 1;
        		if(numDecodings(getSubStr(s,2))==0) return 0;
        		return numDecodings(getSubStr(s,2));
        	}
        	else{
        		if(s_chars.length==2) return 2;
        		if(numDecodings(getSubStr(s,1))==0 && numDecodings(getSubStr(s,2))==0) return 0;
        		if(numDecodings(getSubStr(s,1))==0) return numDecodings(getSubStr(s,2));
        		if(numDecodings(getSubStr(s,2))==0) return numDecodings(getSubStr(s,1));
        		return numDecodings(getSubStr(s,1))+numDecodings(getSubStr(s,2));
        	}
        }
        else if(s_chars[0]=='2'){
        	if(s_chars[1]=='0'){
        		if(s_chars.length==2) return 1;
        		if(numDecodings(getSubStr(s,2))==0) return 0;
        		return numDecodings(getSubStr(s,2));
        	}
        	else if(s_chars[1]=='7' || s_chars[1]=='8' || s_chars[1]=='9'){
        		if(s_chars.length==2) return 1;
        		if(numDecodings(getSubStr(s,1))==0) return 0;
        		return numDecodings(getSubStr(s,1));
        	}
        	else{
        		if(s_chars.length==2) return 2;
        		if(numDecodings(getSubStr(s,1))==0 && numDecodings(getSubStr(s,2))==0) return 0;
        		if(numDecodings(getSubStr(s,1))==0) return numDecodings(getSubStr(s,2));
        		if(numDecodings(getSubStr(s,2))==0) return numDecodings(getSubStr(s,1));
        		return numDecodings(getSubStr(s,1))+numDecodings(getSubStr(s,2));
        	}
        }
        else{
        	if(s_chars[1]=='0' && s_chars.length==2){
        		return 0;
        	}
        	else{
        	if(numDecodings(getSubStr(s,1))==0) return 0;
        	return numDecodings(getSubStr(s,1));
        	}
        }
        }
    }
	public static int numDecodings1(String s) {
		if(s.length()==0) return 0;
		int n = s.length();
		int[] m = new int[n+1];
		for(int i=0;i<m.length;i++){
			m[i]=0;
		}
		m[n]=1;
		char[] ss = s.toCharArray();
		if(ss[n-1]!='0') m[n-1]=1;
		for(int i=n-2;i>=0;i--){
			int val = ss[i]-'0';
			if(val==0){
				m[i]=0;
			}
			else if(val*10+ss[i+1]-'0'<=26){
				m[i] = m[i+1] + m[i+2];
			}
			else{
				 m[i] = m[i+1];
			}
		}
		return m[0];
	}
	public static String getSubStr(String str,int i){
		int n = str.length();
			return new String(Arrays.copyOfRange(str.toCharArray(), i, n));
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "101";
		//p(getSubStr(x,2));
		String test = "81195";
		p(numDecodings(test));
	}

}
