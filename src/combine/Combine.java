package combine;

import java.util.ArrayList;
import java.util.HashMap;

public class Combine {

	/**
	 * @param args
	 */
	
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n<k || k==0) return result;
		for(int i=1;i<=k;i++){
			ArrayList<ArrayList<Integer>> temp = combineFromLast(n,result);
			result = temp;
		}
		return result;
		
    }
	public static ArrayList<ArrayList<Integer>> combineFromLast(int n,ArrayList<ArrayList<Integer>> previous){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(previous.size()==0){
			for(int i=1;i<=n;i++){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(new Integer(i));
				result.add(temp);
			}
			return result;
		}
		for(int j=0;j<previous.size();j++){
			ArrayList<Integer> element = previous.get(j);
			Integer last_num = element.get(element.size()-1);
			int begin = last_num.intValue();
			if(begin<n){
			for(int x=begin+1;x<=n;x++){
				ArrayList<Integer> temp = (ArrayList<Integer>)element.clone();
				temp.add(new Integer(x));
				result.add(temp);
			}
			}
		}
		return result;
	}
//	public static Integer[] list2array(ArrayList<Integer> list){
//		int n = list.size();
//		Integer[] result = new Integer[n];
//		for(int i=0;i<n;i++){
//			Integer value = list.get(i);
//			result[i]=value;
//		}
//		return result;
//	}
//	public static ArrayList<Integer> array2list(Integer[] array){
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		int n = array.length;
//		for(int i=0;i<n;i++){
//			result.add(array[i]);
//		}
//		return result;
//	}
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = combineFromLast(2,new ArrayList<ArrayList<Integer>>());
		p(result.size());
	}

}
