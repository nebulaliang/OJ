package flattenBinaryTree;

import util.TreeNode;

public class FlattenBinaryTree {

	private static TreeNode last;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		if (last == null) {
			last = root;
		} else {
			TreeNode cur = root;
			last.left = null;
			last.right = cur;
			last = cur;
		}

		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}

}
