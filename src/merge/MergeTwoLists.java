package merge;

import java.util.ArrayList;

public class MergeTwoLists {

	/**
	 * @param args
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode result = null;
		ListNode temp = null;
		if(l1.val<l2.val){
			temp = new ListNode(l1.val);
			l1=l1.next;
		}
		else{
			temp = new ListNode(l2.val);
			l2=l2.next;
		}
		result = temp;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				temp.next = new ListNode(l1.val);
				l1=l1.next;
			}
			else{
				temp.next = new ListNode(l2.val);
				l2=l2.next;
			}
			temp=temp.next;
		}
		if(l1!=null){
			temp.next=l1;
		}
		else{
			temp.next=l2;
		}
		return result;
    }
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ListNode head = null;
        for(ListNode node:lists){
        	head = mergeTwoLists(head,node);
        }
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
