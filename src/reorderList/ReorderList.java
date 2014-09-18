package reorderList;

public class ReorderList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		head.next = a;
		a.next = b;
		b.next = c;
		c.next = null;
		//ListNode.printList(head);
		head=reverseList(head);
		ListNode.printList(head);
	}
	
	public static void reorderList(ListNode head) {
        //First, cut the list into two half
		ListNode i = head;
		ListNode j = head;
		while(j.next!=null && j.next.next!=null){
			i = i.next;
			j = j.next.next;
		}
		ListNode second_half = i.next;
		i.next = null;
		//reverse the second half
		second_half = reverseList(second_half);
		//merge these two lists
		ListNode x = head;
		ListNode y = x.next;
		ListNode m = second_half;
		ListNode n = m.next;
		x.next = m;
		m.next = y;
		while(n!=null){
			x=y;
			m=n;
			y=y.next;
			n=n.next;
			x.next = m;
			m.next = y;
		}
    }
	
	public static ListNode reverseList(ListNode head){
		ListNode i = head;
		ListNode j = i.next;
		ListNode pre = null;
		while(j!=null){
			i.next = pre;
			pre = i;
			i = j;
			j = j.next;
		}
		i.next = pre;
		head = i;
		return head;
	}
}
