package subsets;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	//	Subsets
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
    //method 1: BFS
    public ArrayList<ArrayList<Integer>> subsets_BFS(int[] S) {
        Arrays.sort(S);
         ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
         subsets.add(new ArrayList<Integer>());
          for (int i = 0; i < S.length; i++) {
              int size = subsets.size();
             for (int j = 0; j < size; j++) {
                  ArrayList<Integer> subset = new ArrayList<Integer>(
                         subsets.get(j));
                subset.add(S[i]);
                 subsets.add(subset);
            }
         }
         return subsets;
    }
    //method 2: DFS
    public ArrayList<ArrayList<Integer>> subsets_DFS(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(result, temp, S, 0);
        return result;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] S, int start){
        result.add(new ArrayList<Integer>(temp));
        
        for(int i = start; i < S.length; i++){
            temp.add(S[i]);
            dfs(result, temp, S, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
	//	Subsets II 
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
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        dfs(result, temp, num, 0);
        return result;
    }
    
    public static void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int[] S, int start){
        result.add(new ArrayList<Integer>(temp));
        
        for(int i = start; i < S.length; i++){
            if(i != start && S[i] == S[i - 1]){
                continue;
            }
            temp.add(S[i]);
            helper(result, temp, S, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
