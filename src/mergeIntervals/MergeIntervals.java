package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    private Comparator<Interval> cmp = new Comparator<Interval>(){
        public int compare(Interval left, Interval right){
            return left.start - right.start;
        }
    };
    
    public List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int n = intervals.size();
        if(n==0) return result;
        if(n==1) return intervals;
        Collections.sort(intervals, cmp);
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

}
