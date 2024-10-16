package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {

	public static void main(String[] args) {
		var obj = new MaxNonNegativeSubArray();
		System.out.println(obj.maxset(new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 3))));
		System.out.println(obj.maxset(new ArrayList<>(Arrays.asList(0,0,-1,0))));
		System.out.println(obj.maxset(new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368))));
		System.out.println(obj.maxset(new ArrayList<>(Arrays.asList(-1))));
	}
	
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
    	if(A == null || A.isEmpty()) return A;
    	
    	int j = 0;
    	
    	long max = -1;
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	long sum = 0;
    	while(j < A.size()) {
    		int current = A.get(j);
    		if(current >= 0) {
    			sum += current;
    			temp.add(current);
    		} else {
    			if(sum > max) {
    				max = sum;
    				result = new ArrayList<>(temp);
    			}
    			sum = 0;
    			temp.clear();
    		}
    		j++;
    	}
    	if(sum > max) {
    		result = temp;
    	}
    	return result;
    }	

}
