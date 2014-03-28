package maxDepth;

public class MaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	Given a binary tree, find its maximum depth.
//
//	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
	public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        if(root.left==null && root.right!=null) return 1+maxDepth(root.right);
        if(root.left!=null && root.right==null) return 1+maxDepth(root.left);
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
//	Given a binary tree, find its minimum depth.
//
//	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		if(root.left==null)
			return 1+minDepth(root.right);
		else if(root.right==null)
			return 1+minDepth(root.left);
	    else
	        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

}
