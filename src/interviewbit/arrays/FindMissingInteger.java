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
