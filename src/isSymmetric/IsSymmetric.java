package isSymmetric;

public class IsSymmetric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return dfs(root.left,root.right);
    }
    
    public static boolean dfs(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        return dfs(p.left,q.right) && dfs(p.right,q.left);
    }

}
