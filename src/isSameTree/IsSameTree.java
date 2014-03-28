package isSameTree;

public class IsSameTree {

	/**
	 * @param args
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val==q.val){
        	return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
