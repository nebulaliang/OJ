package partition;

import util.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.val < x) {
            head = head.next;
        }
        if (head.next == null) {
            return dummy.next;
        }
        
        ListNode parPos = head.next;
        ListNode node = parPos;
        while (node.next != null) {
            if (node.next.val < x) {
                ListNode j = node.next;
                node.next = j.next;
                head.next = j;
                j.next = parPos;
                head = j;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }

}
