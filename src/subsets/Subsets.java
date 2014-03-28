package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	/**
	 * @param args
	 */
	//	Subsets(leetcode 105)
	//	Given a set of distinct integers, S, return all possible subsets.
	//
	//	Note:
	//	Elements in a subset must be in non-descending order.
	//	The solution set must not contain duplicate subsets.
	//	For example,
	//	If S = [1,2,3], a solution is:
	//
	//	[
	//	  [3],
	//	  [1],
	//	  [2],
	//	  [1,2,3],
	//	  [1,3],
	//	  [2,3],
	//	  [1,2],
	//	  []
	//	]
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int n = S.length;
		Arrays.sort(S);
		ArrayList<Integer> sub = new ArrayList<Integer>();
		result.add(sub);
		ArrayList<ArrayList<Integer>> temp = result;
		for(int i=0;i<n;i++){
			temp = getNext(temp,S);
			result.addAll(temp);
		}
		return result;
    }
	public static ArrayList<ArrayList<Integer>> getNext(ArrayList<ArrayList<Integer>> list,int[] S){
		int n = S.length;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int size = list.size();
		if(size==1){
		for(int i=0;i<n;i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(new Integer(S[i]));
			result.add(temp);
		}
		}
		else{
			for(int k=0;k<size;k++){
				ArrayList<Integer> temp = (ArrayList<Integer>)list.get(k).clone();
				Integer last = temp.get(temp.size()-1);
				for(int i=n-1;i>=0;i--){
					if(S[i]>last){
						ArrayList<Integer> x = (ArrayList<Integer>)temp.clone();
						x.add(new Integer(S[i]));
						result.add(x);
					}
					else{
						break;
					}
				}
			}
		}
		return result;
	}
	//	Subsets II (leetcode 106)
	//	Given a collection of integers that might contain duplicates, S, return all possible subsets.
	//
	//	Note:
	//	Elements in a subset must be in non-descending order.
	//	The solution set must not contain duplicate subsets.
	//	For example,
	//	If S = [1,2,2], a solution is:
	//
	//	[
	//	  [2],
	//	  [1],
	//	  [1,2,2],
	//	  [2,2],
	//	  [1,2],
	//	  []
	//	]
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = new int[]{1,2,3};
		p(subsets(s));
		
	}

}
