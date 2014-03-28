package isBalanced;

public class IsBalanced {

	/**
	 * @param args
	 */
	
	 public static boolean isBalanced(TreeNode root) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(getHeight(root)==-1) return false;
	        return true;
	    }
	public static int getHeight(TreeNode root){
		if(root==null) return 0;
		int leftHeight = getHeight(root.left);
		if(leftHeight==-1) return -1;
		int rightHeight = getHeight(root.right);
		if(rightHeight==-1) return -1;
		if(Math.abs(leftHeight-rightHeight)>1) return -1;
		return (Math.max(leftHeight, rightHeight)+1);
		
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		//node4.left=node5;
		p(getHeight(node1));
		p(isBalanced(node1));
	}

}
