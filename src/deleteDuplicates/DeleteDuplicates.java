package deleteDuplicates;

import util.ListNode;

public class DeleteDuplicates {

	// Given a sorted linked list, delete all duplicates such that each element
	// appear only once.
	//
	// For example,
	// Given 1->1->2, return 1->2.
	// Given 1->1->2->3->3, return 1->2->3.
	public ListNode deleteDuplicates(ListNode head) {
		ListNode i = head;
		while (i != null) {
			while (i.next != null && i.val == i.next.val) {
				i.next = i.next.next;
			}
			i = i.next;
		}

		return head;
	}

	// Given a sorted linked list, delete all nodes that have duplicate numbers,
	// leaving only distinct numbers from the original list.
	//
	// For example,
	// Given 1->2->3->3->4->4->5, return 1->2->5.
	// Given 1->1->1->2->3, return 2->3.
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
