package maxPathSum;

import util.TreeNode;

public class MaxPathSum {

    public class ResultType {
        int single, max;

        ResultType(int single, int max) {
            this.single = single;
            this.max = max;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        ResultType res = helper(root);
        return res.max;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        // devide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // conquer
        int single = Math.max(left.single, right.single) + root.val;
        single = Math.max(single, 0);

        int max = Math.max(left.max, right.max);
        max = Math.max(max, left.single + right.single + root.val);

        return new ResultType(single, max);

    }

}
