package addTwoNumbers;

import util.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry > 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            sum += carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            
        }
        
        return dummy.next;
	}

}
