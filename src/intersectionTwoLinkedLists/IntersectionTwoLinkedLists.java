package intersectionTwoLinkedLists;

import util.ListNode;

public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int stepA = 0;
        int stepB = 0;
        while (curA.next != null) {
            curA = curA.next;
            stepA++;
        }
        while (curB.next != null) {
            curB = curB.next;
            stepB++;
        }
        if (curA != curB) {
            return null;
        }
        curA = headA;
        curB = headB;
        if (stepA > stepB) {
            int diff = stepA - stepB;
            while (diff > 0) {
                curA = curA.next;
                diff--;
            }
        }
        if (stepA < stepB) {
            int diff = stepB - stepA;
            while (diff > 0) {
                curB = curB.next;
                diff--;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
