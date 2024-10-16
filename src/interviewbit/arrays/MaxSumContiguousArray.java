package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousArray {

	public static void main(String[] args) {
		var obj = new MaxSumContiguousArray();
		System.out.println(obj.maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
	}
	
    public int maxSubArray(final List<Integer> A) {
        final int[] aux = new int[A.size()];
        aux[0] = A.get(0);
        for(int i = 1; i < aux.length; i++) {
            int current = A.get(i);
            aux[i] = Math.max(current, current + aux[i-1]);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < aux.length; i++) {
            max = Math.max(aux[i], max);
        }
        return max;
    }	

}
