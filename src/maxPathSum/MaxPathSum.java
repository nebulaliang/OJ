package maxPathSum;


public class MaxPathSum {

	/**
	 * @param args
	 */
	public static int m1 = Integer.MIN_VALUE;
    public static int maxSum(TreeNode root) {
        if(root==null)
            return 0;
        
        int l=maxSum(root.left);
        int r=maxSum(root.right);
        int m=root.val;
        if(l>0) m+=l;
        if(r>0) m+=r;
        m1=Math.max(m1,m);
        return Math.max(root.val,Math.max(l,r)+root.val);
       // return Math.max(l,r)>0?Math.max(l,r)+root.val:root.val;
    }
    public static int maxPathSum(TreeNode root) {
        //int my = root.val;
        int max = maxSum(root);
        return Math.max(max,m1);
    }
    public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(1);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node3.left=node5;
		node3.right=node6;
		node4.left=node7;
		node4.right=node8;
		node6.right=node9;
		p(maxPathSum(node1));
	}

}
