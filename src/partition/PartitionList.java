package partition;

public class PartitionList {

	/**
	 * @param args
	 */
	public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head==null || head.next==null) return head;
        ListNode new_h = new ListNode(-1);
        new_h.next = head;
        ListNode before = new_h;
        ListNode i = before.next;
        ListNode par_pos=null;
        while(i!=null){
        	if(i.val>=x){
        		par_pos = i;
        		break;
        	}
        	else{
        		i = i.next;
        		before = before.next;
        	}
        }
        if(par_pos==null) return head;
        ListNode b = par_pos;
        while(b.next!=null){
        	ListNode j = b.next;
        	if(j.val<x){
        		b.next = j.next;
        		j.next = par_pos;
        		before.next = j;
        		before = j;
        	}
        	else{
        		b = b.next;
        	}
        }
        return new_h.next; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
