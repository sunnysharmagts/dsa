package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

	public static void main(String[] args) {
		var obj = new NextPermutation();
		System.out.println(obj.nextPermutation(new ArrayList<>(Arrays.asList(1,3,2))));
	}
	
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
    	
    	int index = -1;
    	int i = A.size() - 1;
    	while(i > 0) {
    		if(A.get(i) > A.get(i - 1)) {
    			index = i - 1;
    			break;
    		}
    		i--;
    	}
    	if(index == -1) {
    		Collections.reverse(A);
    		return A;
    	}
    	i = A.size() - 1;
    	while(i > index) {
    		if(A.get(index) < A.get(i)) {
    			int temp = A.get(index);
    			A.set(index, A.get(i));
    			A.set(i, temp);
    			reverse(A, index + 1, A.size()-1);
    			break;
    		}
    		i--;
    	}
    	return A;
    }

	private void reverse(ArrayList<Integer> a, int i, int j) {
		while(i < j) {
			int temp = a.get(i);
			a.set(i, a.get(j));
			a.set(j, temp);
			i++;
			j--;
		}
	}	

}
