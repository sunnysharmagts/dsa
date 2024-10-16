package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        final ArrayList<Interval> result = new ArrayList<Interval>();
        for(int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
        	if((newInterval.start >= current.start && newInterval.start <= current.end) ||
            ((current.start >= newInterval.start && current.start <= newInterval.end))) {
        		newInterval = new Interval(Math.min(newInterval.start, current.start), Math.max(newInterval.end, current.end));
        	} else if(current.start < newInterval.start) {
        		result.add(current);
        	} else {
        		result.add(newInterval);
        		newInterval = current;
        	}
        }
        result.add(newInterval);
        return result;
    }
    
	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}    

}
