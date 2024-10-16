package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		var obj = new MoveZeros();
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(0,1,0,3,4,0,5,2))));
	}
	
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
    	
    	int i = 0;
    	int j = 0;
    	
    	while(j < A.size()) {
    		while(i <= j && A.get(i) != 0) {
    			i++;
    		}
    		while(j < A.size() && A.get(j) == 0) {
    			j++;
    		}
    		if(j >= A.size()) break;
    		if(i < j) {
    			int temp = A.get(i);
    			A.set(i, A.get(j));
    			A.set(j, temp);
    		}
    		else {
    			j++;
    		}
    	}
    	return A;
    }	

}
