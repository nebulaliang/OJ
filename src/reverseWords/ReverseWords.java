package reverseWords;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("the sky is blue"));
	}
	public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        int len = strs.length;
        StringBuffer sb = new StringBuffer();
        for(int i=len-1;i>=0;i--){
            if(strs[i].trim().equals(""))
                continue;
            sb.append(strs[i].trim());
            if(i!=0 && len>1)
                sb.append(" ");
        }
        return sb.toString().trim();
    }	
}
