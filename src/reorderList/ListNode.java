package reorderList;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	    val = x;
	    next = null;
	}
	public static void printList(ListNode head){
		ListNode i = head;
		while(i!=null){
			System.out.println(i.val);
			i = i.next;
		}
	}
}
