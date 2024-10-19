package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOneToNumber {

	public static void main(String[] args) {
		var obj = new AddOneToNumber();
//		System.out.println(obj.plusOne(new ArrayList<>(Arrays.asList(0))));
//		System.out.println(obj.plusOne(new ArrayList<>(Arrays.asList(9,9,9))));
		System.out.println(obj.plusOne(new ArrayList<>(Arrays.asList(2, 5, 6, 8, 6, 1, 2, 4, 5))));
		System.out.println(obj.plusOne(new ArrayList<>(Arrays.asList(0, 3, 7, 6, 4, 0, 5, 5, 5))));
		System.out.println(obj.plusOne(new ArrayList<>(Arrays.asList(3,0,6,4,0))));
		
	}
	
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        int i = A.size() - 1;
        final ArrayList<Integer> result = new ArrayList<Integer>();
        while(i >= 0) {
            int sum = A.get(i) + carry;
            if(sum < 9) {
                result.add(sum);
                carry = 0;
            } else {
                int diff = sum % 10;
                result.add(diff);
                carry = sum / 10;
            }
            i--;
        }
        if(carry > 0) {
            result.add(carry);
        }
        while(result.get(result.size()-1) == 0) {
        	result.remove(result.size() - 1);
        }
        Collections.reverse(result);
        return result;
    }	

}
