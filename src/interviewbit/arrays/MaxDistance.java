package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxDistance {

	public static void main(String[] args) {
		var obj = new MaxDistance();
		System.out.println(obj.maximumGap(Arrays.asList(3, 5, 4, 2)));
	}
	
    public int maximumGap(final List<Integer> A) {
    	final List<int[]> list = new ArrayList<int[]>();
    	for(int i = 0; i < A.size(); i++) {
    		list.add(new int[] {A.get(i), i});
    	}
    	Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
				return Integer.compare(a[0], b[0]);
			}
		});
    	
    	int j = list.size() - 1;
    	int i = list.size() - 1;
    	int max = 0;
    	while(j >= 0) {
    		if(list.get(i)[1] < list.get(j)[1]) {
    			i--;
    		} else {
    			max = Math.max(max, list.get(i)[1] - list.get(j)[1]);
    		}
    		j--;
    	}
    	return max;
    }

}
