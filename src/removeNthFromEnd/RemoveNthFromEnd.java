package removeNthFromEnd;

public class RemoveNthFromEnd {

	/**
	 * @param args
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head.next==null) return null;
		ListNode i = head;
		ListNode j = head;
        for(int k=1;k<=n;k++){
        	j = j.next;
        }
        if(j==null) return head.next;
        while(j.next!=null){
        	i = i.next;
        	j = j.next;
        }
        i.next = i.next.next;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
