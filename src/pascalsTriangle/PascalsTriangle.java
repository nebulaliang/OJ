package pascalsTriangle;

import java.util.ArrayList;

public class PascalsTriangle {

	/**
	 * @param args
	 */
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(new Integer(1));
		if(numRows==0) return result;
		result.add(temp);
		if(numRows==1) return result;
        for(int i=1;i<numRows;i++){
        	ArrayList<Integer> new_one = getNext(temp);
        	result.add(new_one);
        	temp = new_one;
        }
        return result;
    }
	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(new Integer(1));
		if(rowIndex==0) return temp;
        for(int i=1;i<rowIndex;i++){
        	ArrayList<Integer> new_one = getNext(temp);
        	temp = new_one;
        }
        return temp;
    }
	public static ArrayList<Integer> getNext(ArrayList<Integer> ints){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(new Integer(1));
		Integer last = ints.get(0);
		for(int i=1;i<ints.size();i++){
			Integer now = ints.get(i);
			result.add(new Integer(last+now));
			last = now;
		}
		result.add(new Integer(1));
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
