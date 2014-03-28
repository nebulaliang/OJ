package lengthOfLastWord;

public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.equals("")) return 0;
        int n = s.length();
        int count = 0;
        for(int i=n-1;i>=0;i--){
        	if(s.charAt(i)!=' '){
        		count++;
        	}
        	else{
        		if(count!=0) return count;
        	}
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
