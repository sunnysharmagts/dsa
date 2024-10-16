package interviewbit.arrays;

import java.util.Arrays;
import java.util.List;

public class N_3RepeatNumber {

	public static void main(String[] args) {
		var obj = new N_3RepeatNumber();
		System.out.println(obj.repeatedNumber(Arrays.asList(1000441, 1000441, 1000994)));

	}
	
	public int repeatedNumber(final List<Integer> a) {
		int first = -1;
		int second = -1;
		int c1 = 0;
		int c2 = 0;
		
		for(int num : a) {
			if(num == first) {
				c1++;
			}
			else if(num == second) {
				c2++;
			}
			else if(c1 == 0){
				first = num;
				c1++;
			}
			else if(c2 == 0) {
				second = num;
				c2++;
			}
			else {
				c1--;
				c2--;
			}
		}
		c1 = 0;
		c2 = 0;
		for(int num : a) {
			if(first == num) {
				c1++;
			}
			else if(second == num) {
				c2++;
			}
		}
		int finalCount = 0;
		int element = -1;
		if(c1 > c2) {
			finalCount = c1;
			element = first;
		}
		else {
			finalCount = c2;
			element = second;
		}
		return finalCount > (a.size()/3) ? element : -1; 
	}	

}
