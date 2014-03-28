package addBinary;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static String  addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int a_len = a.length();
		int b_len = b.length();
		int len_diff = Math.abs(a_len-b_len);
		if(a_len>b_len)	{
			for(int i=0;i<len_diff;i++){
				b = "0"+b;
			}
		}
		else{
			for(int i=0;i<len_diff;i++){
				a = "0"+a;
			}
		}
        char[] a_chars = a.toCharArray();
        char[] b_chars = b.toCharArray();
        int increments_length = a.length()+1;
        int result_length = increments_length;
        char[] increments_chars = new char[increments_length];
        char[] result_chars = new char[result_length];
        //The last increment is 0
        increments_chars[increments_length-1] = '0';
        for(int i=a_chars.length-1;i>=0;i--){
        	int a_dig = Character.getNumericValue((a_chars[i]));
        	int b_dig = Character.getNumericValue((b_chars[i]));
        	int increment = Character.getNumericValue((increments_chars[i+1]));
        	int sum = a_dig + b_dig + increment;
        	if(sum==0){
        		increments_chars[i] = '0';
        		result_chars[i+1] = '0';
        	}
        	else if(sum==1){
        		increments_chars[i] = '0';
        		result_chars[i+1] = '1';
        	}
        	else if(sum==2){
        		increments_chars[i] = '1';
        		result_chars[i+1] = '0';
        	}
        	else{
        		increments_chars[i] = '1';
        		result_chars[i+1] = '1';
        	}
        }
        result_chars[0]=increments_chars[0];
        //p(new String(result_chars));
        String result = new String(result_chars);
        if(result_chars[0]=='0'){
        	result = result.substring(1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "123";
		char[] a_char = a.toCharArray();
		//p(Character.getNumericValue((a_char[1]))+1);
		p(addBinary("11","100"));
	}

}
