package addTwoNumbers;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode result = null;
        if(l1==null && l2==null) return result;
        int carry = 0;
        int value = carry;
        if(l1!=null) value+=l1.val;
        if(l2!=null) value+=l2.val;
        result = new ListNode(value%10);
        ListNode l = result;
        carry = value/10;
        if(l1!=null) l1=l1.next;
        if(l2!=null) l2=l2.next;
        while(l1!=null || l2!=null || carry==1){
        	value = carry;
            if(l1!=null) value+=l1.val;
            if(l2!=null) value+=l2.val;
            ListNode more = new ListNode(value%10);
            l.next = more;
            l=l.next;
            carry = value/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
