package twoSum;

import java.util.HashMap;
public class TwoSum {

	/**
	 * @param args
	 */
	public int[] twoSum(int[] numbers, int target) {
		//define a hashmap to store the history number in numbers(key is number,value is the index);
        //go through number(n) in numbers, check whether there is number in hash x s.t. x = target - n;
        //if yes, return the two indices
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            int cur_index = i+1;
            Integer num = new Integer(numbers[i]);
            Integer diff = new Integer(target - num);
            //check whether there is number x in hash s.t. x = target - n;
            if(map.containsKey(diff)){
                int index = map.get(diff).intValue();
                return new int[]{index,cur_index};
            }
            //if the hash has same key, do nothing
            if(!map.containsKey(num)){
                map.put(num,cur_index);
            }
            
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
