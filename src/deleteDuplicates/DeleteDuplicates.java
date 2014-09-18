package deleteDuplicates;

public class DeleteDuplicates {

	/**
	 * @param args
	 */
	//leetcode 79:
	//	Given a sorted linked list, delete all duplicates such that each element appear only once.
	//
	//	For example,
	//	Given 1->1->2, return 1->2.
	//	Given 1->1->2->3->3, return 1->2->3.
	public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head==null) return head;
        int curr_val = head.val;
        ListNode i = head;
        ListNode j = head.next;
        while(j!=null){
        	//if same value, delete the j node
        	if(i.val==j.val){
        		j = j.next;
        		i.next = j;
        	}
        	else{
        		i = i.next;
        		j = j.next;
        	}
        }
        return head;
    }
	//leetcode 80:
	//	Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	//
	//	For example,
	//	Given 1->2->3->3->4->4->5, return 1->2->5.
	//	Given 1->1->1->2->3, return 2->3.
	 public ListNode deleteDuplicates1(ListNode head) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(head==null) return head;
	     int curr_val = head.val;
	     ListNode new_h = new ListNode(-1);
	     new_h.next = head;
	     ListNode before = new_h;
	     ListNode i = head;
	     ListNode j = head.next;
	     while(j!=null){
	    	 if(i.val==j.val){
	    		 if(j.next==null){
	    			 before.next = null;
	    			 break;
	    		 }
	    		 while(j!=null){
	    			 if(j.val!=i.val){
	    				 before.next = j;
	    				 i = j;
	    				 j = i.next;
	    				 break;
	    			 }
	    			 else{
	    				 j = j.next;
	    				 if(j==null){
	    	    			 before.next = null;
	    	    			 break;
	    	    		 }
	    			 }
	    		 }
	    	 }
	    	 else{
	    		 	before = before.next;
	        		i = i.next;
	        		j = j.next;
	        }
	     }
	     return before.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
