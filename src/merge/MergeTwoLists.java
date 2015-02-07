package merge;

import util.ListNode;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }

            head = head.next;

        }

        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeTwoLists(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode i = head;
        ListNode j = head;
        while (j.next != null && j.next.next != null) {
            i = i.next;
            j = j.next.next;
        }
        return i;
    }
}
