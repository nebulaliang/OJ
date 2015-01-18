package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
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

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length == 0) {
			return result;
		}

		Arrays.sort(candidates);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		dfs(result, temp, target, 0, candidates);

		return result;
	}

	private void dfs(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> temp, int target, int start, int[] candidates) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(temp));
		}

		int passed = -1;
		for (int i = start; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (candidate > target) {
				break;
			}
			if (passed == candidate) {
				continue;
			}

			temp.add(candidate);
			dfs(result, temp, target - candidate, i, candidates);
			temp.remove(temp.size() - 1);

			passed = candidate;
		}
	}

}
