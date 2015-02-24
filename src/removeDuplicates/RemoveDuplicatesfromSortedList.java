package removeDuplicates;

import util.ListNode;

public class RemoveDuplicatesfromSortedList {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode i = head;
        while(i != null) {
            while (i.next != null && i.val == i.next.val) {
                i.next = i.next.next;
            }
            i = i.next;
        }
        
        return head;
    }
    
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                ListNode node = head.next.next;
                int value = head.next.val;
                while (node.next != null && node.next.val == value) {
                    node = node.next;
                }
                head.next = node.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
