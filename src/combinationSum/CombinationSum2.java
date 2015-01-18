package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/
public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, num, target, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] num, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        
        for (int i = start; i < num.length; i++) {
            int val = num[i];
            if (val > target) {
                break;
            }
            if (i != start && num[i] == num[i - 1]) {
                continue;
            }
            temp.add(val);
            dfs(res, temp, num, target - val, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

}
