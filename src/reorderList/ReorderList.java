package reorderList;

import util.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return;
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
        //wave these two lists
        waveLists(head, second_half);
    }
    
    private void waveLists(ListNode head1, ListNode head2) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
    
    private ListNode reverseList(ListNode head){
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
