package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public class MyComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            Interval i1 = (Interval)o1;
            Interval i2 = (Interval)o2;
            return i1.start - i2.start;
        }
    }
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Interval> result = new ArrayList<Interval>();
		int n = intervals.size();
		if(n==0) return result;
		if(n==1) return intervals;
		Collections.sort(intervals, new MyComparator());
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for(int i=1;i<n;i++){
			Interval temp = intervals.get(i);
			if(end<temp.start){
				result.add(new Interval(start,end));
				start = temp.start;
				end = temp.end;
			}
			else{
				end = Math.max(end, temp.end);
			}
		}
		result.add(new Interval(start,end));
		return result;
    }
//	public static ArrayList<Interval> merge2(Interval a, Interval b){
//		ArrayList<Interval> result = new ArrayList<Interval>();
//		int start_a = a.start;
//		int end_a = a.end;
//		int start_b = b.start;
//		int end_b = b.end;
//		if(end_a<start_b){
//			result.add(a);
//			result.add(b);
//			return result;
//		}
//		if(end_b<start_a){
//			result.add(b);
//			result.add(a);
//			return result;
//		}
//		int min = Math.min(start_a, start_b);
//		int max = Math.max(end_a, end_b);
//		result.add(new Interval(min,max));
//		return result;
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
