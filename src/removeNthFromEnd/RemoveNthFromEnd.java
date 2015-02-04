package removeNthFromEnd;

import util.ListNode;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        
        for (int k = 0; k < n; k++) {
            j = j.next;
        }
        
        if (j == null) {//this case means the first node need to be deleted
            return head.next;
        } else {
            while (j.next != null) {
                i = i.next;
                j = j.next;
            }
            //now i point to the node which need to be deleted
            i.next = i.next.next;
        }
        
        return head;
    }

}
