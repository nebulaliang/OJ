package maxArea;

public class MaxArea {

	/**
	 * @param args
	 */
	public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right){
        	int area = (right-left)*Math.min(height[left], height[right]);
        	max = Math.max(max,area);
        	if(height[left]<height[right]){
        		left++;
        		while(height[left]<height[left-1]) left++;
        	}
        	else{
        		right--;
        		while(height[right]<height[right+1]) right--;
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
