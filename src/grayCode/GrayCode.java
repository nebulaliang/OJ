package grayCode;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * @param args
	 */
	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(new Integer(0));
		if(n==0) return result;
		for(int i=0;i<n;i++){
			result = getNext(result,i);
		}
        return result;
    }
	public static ArrayList<Integer> getNext(ArrayList<Integer> list,int n){
		ArrayList<Integer> toAdd = new ArrayList<Integer>();
		Integer adder = new Integer((int)(Math.pow(2, n)));
		for(int i=0;i<list.size();i++){
			toAdd.add(list.get(i)+adder);
		}
		for(int i=toAdd.size()-1;i>=0;i--){
			list.add(toAdd.get(i));
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
