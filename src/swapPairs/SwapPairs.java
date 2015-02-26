package swapPairs;

import util.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode i = head;
        ListNode j = head.next;
        ListNode remain = swapPairs(j.next);
        i.next = remain;
        j.next = i;
        return j;
    }
}
