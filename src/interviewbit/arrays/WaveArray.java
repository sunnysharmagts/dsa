package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class WaveArray {

	public static void main(String[] args) {
		var obj = new WaveArray();
//		System.out.println(obj.wave(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8))));
//		System.out.println(obj.wave(new ArrayList<>(Arrays.asList(1,2))));
//		System.out.println(obj.wave(new ArrayList<>(Arrays.asList(1,2,3,4))));
//		System.out.println(obj.wave(new ArrayList<>(Arrays.asList(1,1,1,2))));
		System.out.println(obj.wave(new ArrayList<>(Arrays.asList(11, 8, 7, 9, 2, 10, 2))));
	}
	
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
    	if(A == null || A.size() <= 1) return A;
    	
    	Collections.sort(A);
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.offer(A.get(0));
    	final ArrayList<Integer> result = new ArrayList<Integer>();
    	for(int i = 1; i < A.size(); i++) {
    		int current = A.get(i);
    		if(queue.isEmpty()) {
    			queue.offer(current);
    		}
    		else if(current >= queue.peek()){
    			result.add(current);
    			result.add(queue.poll());
    		}
    	}
    	while(!queue.isEmpty()) {
    		result.add(queue.poll());
    	}
    	return result;
    }	
}
