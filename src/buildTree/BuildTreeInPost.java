package buildTree;

import java.util.Arrays;

public class BuildTreeInPost {

	/**
	 * @param args
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length==0 && postorder.length==0) return null;
        int n = inorder.length;
        int root_val = postorder[n-1];
        TreeNode root = new TreeNode(root_val);
        int index=0;
        for(int i=0;i<n;i++){
        	if(inorder[i]==root_val) index=i;
        }
        int[] inorder_left = new int[]{};
        if(index!=0) inorder_left= Arrays.copyOfRange(inorder, 0, index);
        int[] inorder_right = new int[]{};
        if(index!=n-1) inorder_right = Arrays.copyOfRange(inorder, index+1, n);
        int[] postorder_left = new int[]{};
        if(index!=0) postorder_left = Arrays.copyOf(postorder, inorder_left.length);
        int[] postorder_right = new int[]{};
        if(index!=n-1) postorder_right = Arrays.copyOfRange(postorder, index,n-1);
        
        root.left = buildTree(inorder_left,postorder_left);
        root.right = buildTree(inorder_right,postorder_right);
        return root;
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = new int[]{1,2,3,4};
		int[] postorder = new int[]{3,2,1,4};
		TreeNode tree = buildTree(inorder,postorder);
		int[] i = Arrays.copyOfRange(inorder, 1, 4);
		int[] j = Arrays.copyOf(postorder,postorder.length);
		p(j[3]);
	}

}
