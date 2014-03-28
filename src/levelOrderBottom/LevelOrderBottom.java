package levelOrderBottom;

import java.util.ArrayList;
import java.util.Stack;

import levelOrderBottom.TreeNode;

public class LevelOrderBottom {

	/**
	 * @param args
	 */
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<ArrayList<TreeNode>> s = new Stack<ArrayList<TreeNode>>();
		if(root==null) return result;
		ArrayList<TreeNode> first_level = new ArrayList<TreeNode>();
		first_level.add(root);
		s.push(first_level);
		ArrayList<TreeNode> work_level = first_level;
		while(!work_level.isEmpty()){
			ArrayList<TreeNode> next_level = new ArrayList<TreeNode>();
			for(TreeNode t:work_level){
				if(t.left!=null) next_level.add(t.left);
				if(t.right!=null) next_level.add(t.right);
			}
			if(!next_level.isEmpty()){
				s.push(next_level);
			}
			work_level = next_level;
		}
		while(!s.empty()){
			ArrayList<TreeNode> trees = s.pop();
			ArrayList<Integer> integers = new ArrayList<Integer>();
			for(TreeNode t:trees){
				integers.add(new Integer(t.val));
			}
			result.add(integers);
		}
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
