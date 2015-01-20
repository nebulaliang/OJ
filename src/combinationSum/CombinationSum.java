package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/
public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res, temp, candidates, target);
        return res;
	}

	private void dfs(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target) {
		if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            if (temp != null && temp.size() > 0 && num < temp.get(temp.size() - 1)) {
                continue;
            }
            temp.add(num);
            dfs(res, temp, candidates, target - num);
            temp.remove(temp.size() - 1);
        }
	}

}
