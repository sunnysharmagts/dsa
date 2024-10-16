package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MergingOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        final ArrayList<Interval> result = new ArrayList<Interval>();
        Interval current = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
        	Interval j = intervals.get(i);
        	if(j.start >= current.start && j.start <= current.end) {
        		current = new Interval(Math.min(j.start, current.start), Math.max(j.end, current.end));
        	} else {
        		result.add(current);
        		current = j;
        	}
        }
        result.add(current);
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
