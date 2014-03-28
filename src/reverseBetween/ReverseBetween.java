package reverseBetween;

public class ReverseBetween {

	/**
	 * @param args
	 */
	//Reverse Nodes in k-Group(leetcode 86)
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(head.next==null) return head;
    	if(m==n) return head;
		ListNode new_h = new ListNode(-1);
        new_h.next = head;
        ListNode before = new_h;
        int count = 0;
        for(;count<m-1;count++){
        	before = before.next;
        }
        count++;
        ListNode first_before = before;
        ListNode first = before.next;
        before = before.next;
        ListNode i = before.next;
        ListNode j = i.next;
        for(;count<n-1;count++){
            i.next = before;
        	before = i;
        	i = j;
        	j = i.next;
        }
        first_before.next = i;
        i.next = before;
        first.next = j;
        return new_h.next;
    }
	//  Reverse Linked List II(leetcode 85)
	//	Reverse a linked list from position m to n. Do it in-place and in one-pass.
	//
	//	For example:
	//	Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	//
	//	return 1->4->3->2->5->NULL.
	public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int n = 0;
		ListNode i = head;
		while(i!=null){
			i = i.next;
			n++;
		}
		int[][] range = getList(n,k);
		for(int j=0;j<range.length;j++){
			head = reverseBetween(head,range[j][0],range[j][1]);
		}
		return head;
    }
	public static int[][] getList(int n, int k){
		int time = n/k;
		int result[][] = new int[time][2];
		for(int i=0;i<time;i++){
			result[i][0] = i*k+1;
			result[i][1] = (i+1)*k;
		}
		return result;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
