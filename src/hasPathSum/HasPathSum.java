package hasPathSum;

import java.util.ArrayList;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
        if(root.val==sum && root.left==null && root.right==null)
        	return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		dfs(root,sum,new ArrayList<Integer>(),result);
		return result;
    }
	
	public static void dfs(TreeNode t,int sum,ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
		if(t==null) return;
		temp.add(t.val);
		if(t.val==sum && t.left==null && t.right==null){
			// has to make a copy, otherwise the content may be changed
		    ArrayList<Integer> curPath = new ArrayList<Integer>(temp);
			result.add(curPath);
		}
		else{
			dfs(t.left,sum-t.val,temp,result);
			dfs(t.right,sum-t.val,temp,result);
		}
		//why?
		temp.remove(temp.size()-1);
		
	}
}
