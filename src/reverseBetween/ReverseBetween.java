package reverseBetween;

import util.ListNode;

public class ReverseBetween {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode origin = head;
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            if (next != null) {
                next = next.next;
            } else {
                return head;
            }
        }
        dummy.next = reverseBetween(head, 1, k);
        origin.next = reverseKGroup(next, k);
        return dummy.next;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        //after for loop, head point to the m - 1 node
        ListNode before = head;
        ListNode mNode = before.next;
        ListNode workNode = mNode;
        ListNode nextNode = workNode.next;
        
        for (int i = m; i < n; i++) {
            ListNode temp = nextNode.next;
            nextNode.next = workNode;
            workNode = nextNode;
            nextNode = temp;
        }
        
        mNode.next = nextNode;
        before.next = workNode;
        
        return dummy.next;
    }

}
