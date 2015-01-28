package merge;

import util.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {

    private Comparator<ListNode> cmp = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        // init the minimal heap
        int k = lists.size();
        Queue<ListNode> heap = new PriorityQueue<ListNode>(k, cmp);
        for (int i = 0; i < k; i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        // generate the result list
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            // insert the head to tail of the result list
            tail.next = head;
            tail = tail.next;
            if (head.next != null) {
                heap.add(head.next);
            }
        }

        return dummy.next;
    }

}
