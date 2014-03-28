package levelOrder;

import java.util.ArrayList;

public class LevelOrder {

	/**
	 * @param args
	 */
	
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null) return result;
		ArrayList<Integer> first_level = new ArrayList<Integer>();
		first_level.add(new Integer(root.val));
		result.add(first_level);
		ArrayList<TreeNode> work_level = new ArrayList<TreeNode>();
		work_level.add(root);
		while(!work_level.isEmpty()){
			ArrayList<TreeNode> next_level = new ArrayList<TreeNode>();
			for(TreeNode t:work_level){
				if(t.left!=null) next_level.add(t.left);
				if(t.right!=null) next_level.add(t.right);
			}
			if(!next_level.isEmpty()){
				ArrayList<Integer> next_integers = new ArrayList<Integer>();
				for(TreeNode v:next_level){
					next_integers.add(v.val);
				}
				result.add(next_integers);
			}
			work_level = next_level;
		}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
