package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMissingInteger {

	public static void main(String[] args) {
		var obj = new FindMissingInteger();
//		System.out.println(obj.firstMissingPositive(new ArrayList<>(Arrays.asList(3,4,-1,1))));
//		System.out.println(obj.firstMissingPositive(new ArrayList<>(Arrays.asList(1,2,3))));
//		System.out.println(obj.firstMissingPositive(new ArrayList<>(Arrays.asList(1,2,0))));
		System.out.println(obj.firstMissingPositive(new ArrayList<>(Arrays.asList(1,1,1))));
	}
	
	/*
	 * We are looking for first missing positive integer. That means every index would have index + 1 values. 
	 * If not then we need to swap them with their respective values.
	 * 
	 * In case if its greater then List size or negative then just move on.
	 * 
	 * Iterate the list again to check this first index which has either negative number or index value mismatch.
	 * 
	 * If not found that means array has correct values and the first missing positive integer is array length + 1;
	 */
    public int firstMissingPositive(ArrayList<Integer> A) {
    	
    	int i = 0;
    	while(i < A.size()) {
    		int current = A.get(i);
    		if(current <= 0 || (current - 1 == i) || current - 1 >= A.size()) {
    			i++;
    		}
    		else {
    			int val = A.get(current - 1);
    			if(val == current) return i + 1; 
    			A.set(current - 1, current);
    			A.set(i, val);
    		}
    	}
    	for(i = 0; i < A.size(); i++) {
    		int current = A.get(i);
    		if(current <= 0 || current > A.size()) {
    			return i+1;
    		}
    	}
    	return A.size()+1;
    }	

}
