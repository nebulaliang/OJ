package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CombinationSum2 {

	/**
	 * @param args
	 */
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashMap<Integer,ArrayList<ArrayList<Integer>>> map_result = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
		if(target<1) return new ArrayList<ArrayList<Integer>>();
		Arrays.sort(candidates);
		
		if(Arrays.binarySearch(candidates, 1)>=0){
			ArrayList<ArrayList<Integer>> result1 = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(new Integer(1));
			result1.add(temp);
			map_result.put(new Integer(1), result1);
		}
		else{
			map_result.put(new Integer(1), new ArrayList<ArrayList<Integer>>());
		}
		if(target==map_result.size()) return map_result.get(new Integer(target));
		
		for(int i=2;i<=target;i++){
			if(Arrays.binarySearch(candidates, i)>=0){
				ArrayList<ArrayList<Integer>> resulti = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(new Integer(i));
				resulti.add(temp);
				map_result.put(new Integer(i), resulti);
			}
			else{
				map_result.put(new Integer(i), new ArrayList<ArrayList<Integer>>());
			}
			for(int j=1;j<=i/2;j++){
				int begin = j;
				int end = i-j;
				if(map_result.get(new Integer(begin)).size()>0 && map_result.get(new Integer(end)).size()>0){
					ArrayList<ArrayList<Integer>> tem = combine2(candidates,map_result.get(new Integer(begin)),map_result.get(new Integer(end)));
					map_result.get(new Integer(i)).addAll(tem);
				}
			}
			map_result.put(new Integer(i), removeDuplicate(map_result.get(new Integer(i))));
		}
		return map_result.get(new Integer(target));
    }
	public static ArrayList<ArrayList<Integer>> removeDuplicate(ArrayList<ArrayList<Integer>> list){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<ArrayList<Integer>,String> map = new HashMap<ArrayList<Integer>,String>();
		for(ArrayList<Integer> element:list){
			ArrayList<Integer> element_copy = (ArrayList<Integer>)element.clone();
			Collections.sort(element_copy);
			if(!map.containsKey(element_copy)){
				map.put(element_copy, "true");
				result.add(element_copy);
			}
		}
		list = result;
		return result;
	}
	public static HashMap<Integer,Integer> getHash(int[] num){
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		for(int i=0;i<num.length;i++){
			Integer number = new Integer(num[i]);
			if(!result.containsKey(number)){
				result.put(number, new Integer(1));
			}
			else{
				result.put(number, result.get(number)+1);
			}
		}
		return result;
	}
	public static HashMap<Integer,Integer> getHash(ArrayList<Integer> list){
		HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
		for(int i=0;i<list.size();i++){
			Integer number = list.get(i);
			if(!result.containsKey(number)){
				result.put(number, new Integer(1));
			}
			else{
				result.put(number, result.get(number)+1);
			}
		}
		return result;
	}
	public static boolean isSubArray(HashMap<Integer,Integer> source,HashMap<Integer,Integer> checker){
		for(Integer number:checker.keySet()){
			if(checker.get(number)>source.get(number)) return false;
		}
		return true;
	}
	public static ArrayList<ArrayList<Integer>> combine2(int[] num,ArrayList<ArrayList<Integer>> first,ArrayList<ArrayList<Integer>> second){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<ArrayList<Integer>,String> map = new HashMap();
		for(ArrayList<Integer> element_first:first){
			for(ArrayList<Integer> element_second:second){
				ArrayList<Integer> element_first_copy = (ArrayList<Integer>)element_first.clone();
				ArrayList<Integer> element_second_copy = (ArrayList<Integer>)element_second.clone();
				element_first_copy.addAll(element_second_copy);
				Collections.sort(element_first_copy);
				HashMap<Integer,Integer> source = getHash(num);
				HashMap<Integer,Integer> checker = getHash(element_first_copy);
				if(!isSubArray(source,checker)) continue;
				if(!map.containsKey(element_first_copy)){
					map.put(element_first_copy, "true");
					result.add(element_first_copy);
				}
			}
		}
		return result;
	}
//	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        Arrays.sort(num);
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        int current_sum = 0;
//        ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
//        for(int i=0;i<num.length && num[i]<=target/2;i++){
//        	ArrayList<Integer> current_int = new ArrayList<Integer>();
//        	current_int.add(new Integer(num[i]));
//        	current.add(current_int);
//        	if(Arrays.binarySearch(num, target)>=0){
//        		ArrayList<Integer> temp = new ArrayList<Integer>();
//        		temp.add(new Integer(target));
//        		result.add(temp);
//        	}
//        	current_sum+=num[i];
//        	if(current_sum<target){
//        		int[] num_remain = Arrays.copyOfRange(num, i+1, num.length-1);
//        		if(combinationSum2(num_remain,target-current_sum)!=null){
//        			
//        			ArrayList<ArrayList<Integer>> remain_result = combinationSum2(num_remain,target-current_sum);
//        			for(ArrayList<Integer> e:remain_result){
//        				ArrayList<Integer> current_int_copy = (ArrayList<Integer>)current_int.clone();
//        				current_int_copy.addAll(e);
//        				result.add(current_int_copy);
//        			}
//        		}
//        	}
//        }
//        return result;
//    }
//	public static ArrayList<ArrayList<Integer>> combine2(ArrayList<ArrayList<Integer>> first,ArrayList<ArrayList<Integer>> second){
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//		HashMap<ArrayList<Integer>,String> map = new HashMap();
//		for(ArrayList<Integer> element_first:first){
//			for(ArrayList<Integer> element_second:second){
//				ArrayList<Integer> element_first_copy = (ArrayList<Integer>)element_first.clone();
//				ArrayList<Integer> element_second_copy = (ArrayList<Integer>)element_second.clone();
//				element_first_copy.addAll(element_second_copy);
//				Collections.sort(element_first_copy);
//				if(!map.containsKey(element_first_copy)){
//					map.put(element_first_copy, "true");
//					result.add(element_first_copy);
//				}
//			}
//		}
//		return result;
//	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[]{10,1,2,7,6,1,5};
		p(combinationSum2(num,8));
	}

}
