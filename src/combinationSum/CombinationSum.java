package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CombinationSum {

	/**
	 * @param args
	 */
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
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
					ArrayList<ArrayList<Integer>> tem = combine2(map_result.get(new Integer(begin)),map_result.get(new Integer(end)));
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
	public static ArrayList<ArrayList<Integer>> combine2(ArrayList<ArrayList<Integer>> first,ArrayList<ArrayList<Integer>> second){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		HashMap<ArrayList<Integer>,String> map = new HashMap();
		for(ArrayList<Integer> element_first:first){
			for(ArrayList<Integer> element_second:second){
				ArrayList<Integer> element_first_copy = (ArrayList<Integer>)element_first.clone();
				ArrayList<Integer> element_second_copy = (ArrayList<Integer>)element_second.clone();
				element_first_copy.addAll(element_second_copy);
				Collections.sort(element_first_copy);
				if(!map.containsKey(element_first_copy)){
					map.put(element_first_copy, "true");
					result.add(element_first_copy);
				}
			}
		}
		return result;
	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		int[] test = new int[]{10,1,2,7,6,1,5};
		Arrays.sort(test);
		p(combinationSum(test,8));
	}

}
