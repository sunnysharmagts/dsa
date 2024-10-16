package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumbers {

	public static void main(String[] args) {
		var obj = new LargestNumbers();
//		System.out.println(obj.largestNumber(Arrays.asList(0,0,0)));
//		System.out.println(obj.largestNumber(Arrays.asList(3, 30, 34, 5, 9)));
		System.out.println(obj.largestNumber(Arrays.asList(9, 99, 999, 9999, 9998)));
	}
	
	/*
	 * STATUS - REJECTED
	 * 
	 * Time taken: 1 hr
	 * 
	 *  Approach 2
	 */
    public String largestNumber(final List<Integer> A) {
    	if(A == null || A.isEmpty()) return "";
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            String first = s1 + s2;
            String second = s2 + s1;
            return first.compareTo(second) > 0 ? -1 : 1;
    	});
    	
    	for(int num : A) {
    		pq.offer(num);
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	if(pq.isEmpty()) return "0";
    	
    	while(!pq.isEmpty()) {
    		sb.append(pq.poll());
    	}
    	final String result = sb.toString();
    	return result.charAt(0) == '0' ? "0" : result;
    }
    
	/*
	 * STATUS - REJECTED
	 * 
	 * Time taken: 1 hr
	 * 
	 *  Approach 1
	 *  
	 *  Take 2 integers and add it to priority queue. The Priority queue would compare them by :-
	 *  1. break int to digits.
	 *  2. Compare them from start.
	 *  3. If we find a greater digit then return -1, 1 based on that.
	 *  4. If the size of the string is uneven. Compare the last digit with remaining digits and if its greater than the rest of the digits then return that value else return another
	 */ 
	
//    public String largestNumber(final List<Integer> A) {
//    	if(A == null || A.isEmpty()) return "";
//    	
//    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
//    		final Stack<Integer> firstStack = new Stack<Integer>();
//    		final Stack<Integer> secondStack = new Stack<Integer>();
//    		int temp = a;
//    		while(temp > 0) {
//    			firstStack.push(temp % 10);
//    			temp = temp / 10;
//    		}
//    		
//    		temp = b;
//    		while(temp > 0) {
//    			secondStack.push(temp % 10);
//    			temp = temp / 10;
//    		}
//    		int val1 = 0;
//    		int val2 = 0;
//    		while(!firstStack.isEmpty() && !secondStack.isEmpty()) {
//    			val1 = firstStack.pop();
//    			val2 = secondStack.pop();
//    			if(val1 == val2) continue;
//    			if(val1 > val2) return -1;
//    			else return 1;
//    		}
//    		while(!firstStack.isEmpty()) {
//    			val1 = firstStack.pop();
//    			if(val2 == val1) continue;
//    			if(val2 > val1) return 1;
//    			else return -1;
//    		}
//    		while(!secondStack.isEmpty()) {
//    			val2 = secondStack.pop();
//    			if(val2 == val1) continue;
//    			if(val1 > val2) return -1;
//    			else return 1;
//    		}
//			return 0;
//    	});
//    	
//    	for(int num : A) {
//    		pq.offer(num);
//    	}
//    	StringBuilder sb = new StringBuilder();
//    	
//    	if(pq.isEmpty()) return "0";
//    	
//    	while(!pq.isEmpty()) {
//    		sb.append(pq.poll());
//    	}
//    	final String result = sb.toString();
//    	return result.charAt(0) == '0' ? "0" : result;
//    }

}
