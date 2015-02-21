package linkedListCycle;

import util.ListNode;

public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode i = head;
        ListNode j = head;
        while (j.next != null && j.next.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) {
                return true;
            }
        }
        return false;
    }
    
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode i = head;
        ListNode j = head;
        while (j.next != null && j.next.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) {
                i = head;
                while (i != j) {
                    i = i.next;
                    j = j.next;
                }
                return i;
            }
        }
        return null;
    }
}
