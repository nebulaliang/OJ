package populatingNextRightPointers;

public class Connect {

	/**
	 * @param args
	 */
	// leetcode 72
	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return;
        if(root.left!=null){
        	root.left.next = root.right;
        }
        if(root.right!=null){
        	root.right.next = root.next!=null?root.next.left:null;
        }
        connect(root.left);
        connect(root.right);
    }
	//follow up
	//Populating Next Right Pointers in Each Node II
	public void connect1(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root==null) return;
		TreeLinkNode current=null;
        if(root.left!=null){
        	current = root.left;
        	if(root.right!=null){
        		current.next=root.right;
        		current = current.next;
            }
            if(root.next!=null){
            	
            	TreeLinkNode r_next = root.next;
            	while(r_next!=null){
            	if(r_next.left!=null){
            		current.next = r_next.left;
            		current = current.next;
            	}
            	if(r_next.right!=null){
            		current.next = r_next.right;
            		current = current.next;
            	}
            	r_next = r_next.next;
            	}
            }else{
            current.next = null;
            }
        }
        else{//root.left==null
        	if(root.right!=null){
        		current = root.right;
        		if(root.next!=null){
                	TreeLinkNode r_next = root.next;
                	while(r_next!=null){
                    	if(r_next.left!=null){
                    		current.next = r_next.left;
                    		current = current.next;
                    	}
                    	if(r_next.right!=null){
                    		current.next = r_next.right;
                    		current = current.next;
                    	}
                    	r_next = r_next.next;
                    	}
                }
        		else{
        			current.next = null;
        		}
        	}
        	
        }
        connect(root.left);
        connect(root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
