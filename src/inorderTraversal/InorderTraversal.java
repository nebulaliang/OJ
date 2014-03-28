package inorderTraversal;

import inorderTraversal.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
public class InorderTraversal {

	/**
	 * @param args
	 */
	public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root==null) return result;
		TreeNode t = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(t!=null || !s.empty()){
        	if(t!=null){
        		s.push(t);
        		t = t.left;
        	}
        	else{
        		t = s.pop();
        		result.add(new Integer(t.val));
        		t = t.right;
        	}
        }
        return result;
        
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node3.right=node5;
		ArrayList<Integer> result = inorderTraversal(node1);
		for(Integer i:result){
			p(i);
		}
		//1,2,3
	}

}
