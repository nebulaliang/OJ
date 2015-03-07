package levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.TreeNode;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result   = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp  = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
    
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result   = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp  = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(0, temp);
        }
        
        return result;
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result   = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp  = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 != 0) {
                    temp.add(node.val);
                } else {
                    temp.add(0, node.val);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
            level++;
        }
        
        return result;
    }

}
