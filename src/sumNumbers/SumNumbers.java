package sumNumbers;

public class SumNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
	
	public static int dfs(TreeNode root, int sum){
		if(root==null) return 0;
		sum=sum*10+root.val;
		if(root.left==null && root.right==null) return sum;
		return dfs(root.left,sum)+dfs(root.right,sum);
	}
}
