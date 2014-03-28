package countAndSay;

public class CountAndSay {

	/**
	 * @param args
	 */
	public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "1";
        if(n==1) return result;
        for(int i=1;i<n;i++){
        	result = countAndSay_next(result);
        }
        return result;
    }
	public static String countAndSay_next(String str){
		String new_str = "";
		char[] str_chars = str.toCharArray();
		int count = 1;
		if(str_chars.length==1) return "1"+str;
		for(int i=1;i<str_chars.length;i++){
			char last = str_chars[i-1];
			if(str_chars[i]==last){
				count++;
			}
			else{
				new_str+=Integer.toString(count)+String.valueOf(last);
				count=1;
			}
		}
		new_str+=Integer.toString(count)+String.valueOf(str_chars[str_chars.length-1]);
		return new_str;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = countAndSay_next("11211");
		p(x);
	}

}
