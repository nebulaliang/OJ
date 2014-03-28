package rotateList;

public class RotateList {

	/**
	 * @param args
	 */
	//	Rotate List(leetcode 89)
	//	Given a list, rotate the list to the right by k places, where k is non-negative.
	//
	//	For example:
	//	Given 1->2->3->4->5->NULL and k = 2,
	//	return 4->5->1->2->3->NULL.
	public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head==null || head.next==null || n==0) return head;
        ListNode ori = head;
        ListNode i = head;
        ListNode j = i;
        for(int t=1;t<=n;t++){
            if(j!=null)
            j = j.next;
            else{
                j=i.next;
            }
        }
        //if(i==j) return head;
        if(j==null) return head;
        while(j.next!=null){
        	i=i.next;
        	j=j.next;
        }
        head = i.next;
        i.next = null;
        j.next = ori;
        return head;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
