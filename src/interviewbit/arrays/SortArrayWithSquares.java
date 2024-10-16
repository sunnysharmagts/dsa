package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayWithSquares {

	public static void main(String[] args) {
		var obj = new SortArrayWithSquares();
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(-6,-3,-1,0,
				2,4,5,7))));
	}
	
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
    	int i = 0;
    	
    	while(i < A.size() && A.get(i) <= 0) {
    		i++;
    	}
    	int j = i - 1;
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	while(i < A.size() && j >= 0) {
    		if(A.get(i) < Math.abs(A.get(j))) {
    			result.add(A.get(i) * A.get(i));
    			i++;
    		}
    		else if(A.get(i) > Math.abs(A.get(j))){
    			result.add(A.get(j) * A.get(j));
    			j--;
    		}
    		else if(A.get(i) == Math.abs(A.get(j))){
    			result.add(A.get(i) * A.get(i));
    			result.add(A.get(j) * A.get(j));
    			i++;
    			j--;
    		}
    	}
    	while(i < A.size()) {
			result.add(A.get(i) * A.get(i));
			i++;
    	}
    	while(j >= 0) {
			result.add(A.get(j) * A.get(j));
			j--;    		
    	}
    	return result;
    }

}
