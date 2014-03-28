package zigzagLevelOrder;

import java.util.ArrayList;
import java.util.Stack;

import zigzagLevelOrder.TreeNode;

public class ZigzagLevelOrder {

	/**
	 * @param args
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
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
		for(int i=0;i<result.size();i++){
			if(i%2==1){
				ArrayList<Integer> ints = result.get(i);
				ArrayList<Integer> reversed_ints = reverse(ints);
				result.add(i, reversed_ints);
				result.remove(i+1);
			}
		}
		return result;
    }
	public static ArrayList<Integer> reverse(ArrayList<Integer> list){
		Stack<Integer> s = new Stack<Integer>();
		for(Integer i:list){
			s.push(i);
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!s.empty()){
			Integer i = s.pop();
			result.add(i);
		}
		list = result;
		return result;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		ArrayList<Integer> list1 = reverse(list);
		for(Integer i:list1){
			p(i);
		}
	}

}
