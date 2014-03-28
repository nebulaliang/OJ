package largestRectangleArea;

public class LargestRectangleArea {

	/**
	 * @param args
	 */
	public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = height.length;
        int[] pittfall = new int[n];
        for(int i=1;i<n;i++){
        	if(height[i]<height[i-1]){
        		pittfall[i]=height[i];
        	}
        }
        for(int i=0;i<n;i++){
        	
        }
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
