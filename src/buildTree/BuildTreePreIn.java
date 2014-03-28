package buildTree;

import java.util.Arrays;

public class BuildTreePreIn {

	/**
	 * @param args
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
		 if(inorder.length==0 && preorder.length==0) return null;
	        int n = inorder.length;
	        int root_val = preorder[0];
	        TreeNode root = new TreeNode(root_val);
	        int index=0;
	        for(int i=0;i<n;i++){
	        	if(inorder[i]==root_val) index=i;
	        }
	        int[] inorder_left = new int[]{};
	        if(index!=0) inorder_left= Arrays.copyOfRange(inorder, 0, index);
	        int[] inorder_right = new int[]{};
	        if(index!=n-1) inorder_right = Arrays.copyOfRange(inorder, index+1, n);
	        int[] preorder_left = new int[]{};
	        if(index!=0) preorder_left = Arrays.copyOfRange(preorder, 1,index+1);
	        int[] preorder_right = new int[]{};
	        if(index!=n-1) preorder_right = Arrays.copyOfRange(preorder, index+1,n);
	        
	        root.left = buildTree(preorder_left,inorder_left);
	        root.right = buildTree(preorder_right,inorder_right);
	        return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
