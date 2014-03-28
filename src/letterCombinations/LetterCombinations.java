package letterCombinations;

import java.util.ArrayList;
import java.util.Hashtable;

public class LetterCombinations {

	/**
	 * @param args
	 */
	//public Hashtable<String,String[]> map = new Hashtable<String,String[]>();
	
//	public static ArrayList<String> letterCombinations(String digits) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//		ArrayList<String> result = new ArrayList<String>();
//		int n = digits.length();
//		if(n==0) {
//			result.add("");
//			return result;
//		}
//		Hashtable<String,String[]> map = new Hashtable<String,String[]>();
//		map.put("2", new String[]{"a","b","c"});
//		map.put("3", new String[]{"d","e","f"});
//		map.put("4", new String[]{"g","h","i"});
//		map.put("5", new String[]{"j","k","l"});
//		map.put("6", new String[]{"m","n","o"});
//		map.put("7", new String[]{"p","q","r","s"});
//		map.put("8", new String[]{"t","u","v"});
//		map.put("9", new String[]{"w","x","y","z"});
//		char[] digit_char = digits.toCharArray();
//		result = str2ArrayList(map.get(Character.toString(digit_char[0])));
//		if(n>1){
//		for(int i=1;i<n;i++){
//			result = getNext(result,map.get(Character.toString(digit_char[i])));
//		}
//		}
//        return result;
//    }
//	public static ArrayList<String> str2ArrayList(String[] s){
//		ArrayList<String> result = new ArrayList<String>();
//		for(int i=0;i<s.length;i++){
//			result.add(s[i]);
//		}
//        return result;
//	}
//	public static ArrayList<String> getNext(ArrayList<String> from,String[] digit){
//		ArrayList<String> result = new ArrayList<String>();
//		for(int i=0;i<from.size();i++){
//			for(int j=0;j<digit.length;j++){
//				result.add(from.get(i)+digit[j]);
//			}
//		}
//		return result;
//	}
	static String[] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		dfs(digits,0,"",result);
		return result;
    }
	
	private static void dfs(String digits, int start, String temp,ArrayList<String> result){
		//check the availability of temp to decide whether put it in the result
		if(start==digits.length()){
			result.add(temp);
			return;
		}
		int digit = digits.charAt(start)-'0';
		if(digit==0 || digit==1)
			dfs(digits,start+1,temp,result);
		//recursion
		String letters = map[digit];
		for(int i=0;i<letters.length();i++){
			dfs(digits,start+1,temp+letters.charAt(i),result);
		}
		
		
	}
	
	//google assemble interview question
//	编程问题：给一个由1， 0 和 ?组成的字符串，返回所有的matching strings， “
//			?” 可以 match 0 and 1, 比如说：
//			input : 1?? 
//			output: {100, 101, 110, 111}.
//
//
//			input: 100100?00?
//			output: {1001000000,1001000001,1001001000,1001001001}
	public static ArrayList<String> matchStr(String input){
		ArrayList<String> result = new ArrayList<String>();
		match(input,0,"",result);
		return result;
	}
	private static void match(String input,int start, String temp,ArrayList<String> result){
		if(start==input.length()){
			result.add(temp);
			return;
		}
		char c = input.charAt(start);
		if(c-'?'!=0){
			match(input,start+1,temp+c,result);
		}
		else{
			String letters = "01";
			for(int i=0;i<letters.length();i++){
				match(input,start+1,temp+letters.charAt(i),result);
			}
		}
		
		
	}
	
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//p(letterCombinations("023"));
		p(matchStr("100100?00?"));
	}

}
