package traversalTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class TraversalTree {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode t = root;
        while (t != null || !s.isEmpty()) {
            if (t != null) {
                s.push(t);
                result.add(t.val);
                t = t.left;
            } else {
                t = s.pop();
                t = t.right;
            }
        }
        
        return result;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode t = root;
        while (t != null || !s.isEmpty()) {
            if (t != null) {
                s.push(t);
                t = t.left;
            } else {
                t = s.pop();
                result.add(t.val);
                t = t.right;
            }
        }
        
        return result;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode t = root;
        while (t != null || !s.isEmpty()) {
            if (t != null) {
                s.push(t);
                result.add(t.val);
                t = t.right;
            } else {
                t = s.pop();
                t = t.left;
            }
        }
        
        Collections.reverse(result);
        return result;
    }

}
