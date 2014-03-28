package sortedArrayToBST;

import java.util.Arrays;

public class SortedArrayToBST {

	/**
	 * @param args
	 */
	public static void p(Object o){
		System.out.println(o);
	}
	public static TreeNode sortedListToBST(ListNode head) {
		int size = 0;
		ListNode first = head;
		while(first!=null){
        	size++;
        	first = first.next;
        }
		int[] num = new int[size];
		int i=0;
		first=head;
        while(first!=null){
        	int value = first.val;
        	num[i]=value;
        	first = first.next;
        	i++;
        }
        return sortedArrayToBST(num);
    }
	public static TreeNode sortedArrayToBST(int[] num) {
        return array2BST(num,0,num.length-1);
    }
    public static TreeNode array2BST(int[] a, int begin, int end){
    	if(end<begin) return null;
		int mid = (begin+end)/2;
		TreeNode T = new TreeNode(a[mid]);
		T.left=array2BST(a,begin,mid-1);
		T.right=array2BST(a,mid+1,end);
		return T;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node = new ListNode(0);
		TreeNode t = sortedListToBST(node);
	}

}
