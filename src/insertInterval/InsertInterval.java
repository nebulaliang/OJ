package insertInterval;

import java.util.ArrayList;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Interval> result = new ArrayList<Interval>();
        int start = newInterval.start;
        int end = newInterval.end;
        String index_start = "";
        int index_start_at = 0;
        String index_end = "";
        int index_end_at = 0;
        int index_record=0;
        for(int i=0;i<intervals.size();i++){
        	Interval tmp_interval = intervals.get(i);
        	int tmp_start = tmp_interval.start;
            int tmp_end = tmp_interval.end;
            if(start<tmp_start){
            	index_start = "before";
            	index_start_at = i;
            	index_record = i;
            	break;
            }
            else if(tmp_start<=start && start<=tmp_end){
            	index_start = "in";
            	index_start_at = i;
            	index_record = i;
            	break;
            }
        }
        if(index_start.equals("")) {
        	intervals.add(newInterval);
        	return intervals;
        }
        for(int i=index_record;i<intervals.size();i++){
        	Interval tmp_interval = intervals.get(i);
        	int tmp_start = tmp_interval.start;
            int tmp_end = tmp_interval.end;
            if(end<tmp_start){
            	index_end = "before";
            	index_end_at = i;
            	break;
            }
            if(tmp_start<=end && end<=tmp_end){
            	index_end = "in";
            	index_end_at = i;
            	break;
            }
        }
        p(index_record);
        p(index_start_at);p(index_end_at);
        p("index_start:"+index_start);p("index_end:"+index_end);
        if(index_end.equals("")){
        	for(int i=0;i<index_start_at;i++){
    			result.add(intervals.get(i));
    		}
        	if(index_start.equals("before")){
        		result.add(newInterval);
        		return result;
        	}
        	else{
        		Interval tmp = new Interval(intervals.get(index_start_at).start,end);
        		result.add(tmp);
        		return result;
        	}
        }
        if(index_start.equals("before") && index_end.equals("before")){
        	int diff = index_end_at-index_start_at;
        	for(int i=1;i<=diff;i++){
        		intervals.remove(index_start_at);
        	}
        	intervals.add(index_start_at, newInterval);
        	return intervals;
        }
        else if(index_start.equals("before") && index_end.equals("in")){
        	Interval tmp = new Interval(start,intervals.get(index_end_at).end);
        	if(index_start_at==index_end_at) {
        		result.add(tmp);
        		return result;
        	}
        	int diff = index_end_at-index_start_at+1;
        	for(int i=1;i<=diff;i++){
        		intervals.remove(index_start_at);
        	}
        	intervals.add(index_start_at, tmp);
        	return intervals;
        }
        else if(index_start.equals("in") && index_end.equals("before")){
        	Interval tmp = new Interval(intervals.get(index_start_at).start,end);
        	int diff = index_end_at-index_start_at;
        	for(int i=1;i<=diff;i++){
        		intervals.remove(index_start_at);
        	}
        	intervals.add(index_start_at, tmp);
        	return intervals;
        }
        else{
        	if(index_start_at==index_end_at) return intervals;
        	Interval tmp = new Interval(intervals.get(index_start_at).start,intervals.get(index_end_at).end);
        	int diff = index_end_at-index_start_at+1;
        	for(int i=1;i<=diff;i++){
        		intervals.remove(index_start_at);
        	}
        	intervals.add(index_start_at, tmp);
        	return intervals;
        }
    }
	public static void p(Object o){
		System.out.println(o);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Interval> test = new ArrayList<Interval>();
		Interval in = new Interval(1,5);
		Interval in1 = new Interval(9,12);
		test.add(in);
		test.add(in1);
		Interval newIn = new Interval(0,4);
		p(insert(test,newIn).size());
	}

}
