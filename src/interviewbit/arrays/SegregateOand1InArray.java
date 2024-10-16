package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SegregateOand1InArray {

	public static void main(String[] args) {
		var obj = new SegregateOand1InArray();
		System.out.println(obj.solve(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1))));
	}
	
	public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int i = 0;
        int j = A.size() - 1;
        
        while(i <= j) {
            while(i <= j && A.get(i) == 0) {
                i++;
            }
            while(j >= i && A.get(j) != 0) {
                j--;
            }
            if(i >= j) break;
            int temp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, temp);
        }
        return A;
    }	

}
