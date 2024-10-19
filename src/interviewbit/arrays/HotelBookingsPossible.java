package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HotelBookingsPossible {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    	List<int[]> list = new ArrayList<int[]>();
    	for(int i = 0; i < arrive.size(); i++) {
    		list.add(new int[] {arrive.get(i), depart.get(i)});
    	}
    	Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
    	
    	PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b)-> (Integer.compare(a[1], b[1])));
    	queue.offer(list.get(0));
    	K--;
    	for(int i = 1; i < list.size(); i++) {
    		int[] current = list.get(i);
    		while(!queue.isEmpty() && current[0] > queue.peek()[1]) {
    			queue.poll();
    			K++;
    		}
    		if(K <= 0) return false;
    		queue.offer(current);
    		K--;
    	}
    	return true;
    }	

}
