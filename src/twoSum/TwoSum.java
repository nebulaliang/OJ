package twoSum;

import java.util.HashMap;
import java.util
public class TwoSum {

	/**
	 * @param args
	 */
	public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result1=0;
        int result2=0;
        for(int i=0;i<numbers.length;i++){
        	Integer value = new Integer(numbers[i]);
        	Integer diff = target-value;
        	if(map.containsKey(diff)){
        		result1=map.get(diff);
        		result2=i+1;
        		return new int[]{result1,result2};
        	}
        	if(!map.containsKey(value)){
        		map.put(value, i+1);
        	}Integer.MIN_VALUE
        	Math.max(1,3);
        	
        }
        return new int[]{result1,result2};
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
