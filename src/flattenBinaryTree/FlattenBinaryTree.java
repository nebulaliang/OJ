package flattenBinaryTree;


public class FlattenBinaryTree {

	/**
	 * @param args
	 */
	public static int count(TreeNode root){
		if(root==null) return 0;
		if(root.left==null && root.right== null) return 0;
		int lcount = count(root.left);
		int rcount = count(root.right);
		if(root.left==null && root.right!=null) {
			return 1+rcount;
		}
		if(root.right==null && root.left!=null){
			return 1+lcount;
		}
		return lcount+rcount;
	}
		
	
	
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		//基本思想:假设flatten功能已完成，我们先把左边flatten，再把右边flatten，然后把两边拼接起来。
		//这是递归的主要思路。
		if(root==null) return;
		flatten(root.left);
		flatten(root.right);
		if(root.left!=null){
			TreeNode rightMostOfLeft = root.left;
			while(rightMostOfLeft.right!=null){
				rightMostOfLeft=rightMostOfLeft.right;
			}
			TreeNode rchild = root.right;
			root.right = root.left;
			root.left = null;
			rightMostOfLeft.right=rchild;
		}
		
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
		TreeNode node6 = new TreeNode(6);
		node1.left=node2;
		node1.right=node4;
		node2.right=node3;
		node3.left=node5;
		node5.left=node6;
		p(count(node1));
	}

}
