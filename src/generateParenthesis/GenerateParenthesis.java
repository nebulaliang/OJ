package generateParenthesis;

import java.util.ArrayList;

public class GenerateParenthesis {

	/**
	 * @param args
	 */
	// same to careercup150 9.6(Hard)
//	public ArrayList<String> generateParenthesis(int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        return generate_helper("",n,n); 
//    }
//	public static ArrayList<String> generate_helper(String head,int left,int right){
//		ArrayList<String> result = new ArrayList<String>();
//		if(left==0){
//			for(int i=1;i<=right;i++){
//				head+=")";
//			}
//			result.add(head);
//			return result;
//		}
//		ArrayList<String> left_temp = generate_helper(head+"(",left-1,right);
//		result.addAll(left_temp);
//		if(left<right){
//			ArrayList<String> right_temp = generate_helper(head+")",left,right-1);
//			result.addAll(right_temp);
//		}
//		return result;
//	}
	public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
        generate_helper("",n,n,result); 
        return result;
    }
	public static void generate_helper(String head,int left,int right,ArrayList<String> result){
		if(left<0 || right<0) return;
		if(left==0 && right==0){
			result.add(head);
			return;
		}
		generate_helper(head+"(",left-1,right,result);
		//only right remain larger than left remain, we can use recursion
		if(left<right)
			generate_helper(head+")",left,right-1,result);
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
