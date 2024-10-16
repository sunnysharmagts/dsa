package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class LargeFactorial {

	public static void main(String[] args) {
		var obj = new LargeFactorial();
		System.out.println(obj.solve(100));
	}
	
    public String solve(int A) {
    	final List<Integer> result = factorial(A);
    	StringBuilder sb = new StringBuilder();
        for(int i = result.size() - 1; i >=0 ;i --) {
        	sb.append(result.get(i));
        }
        return sb.toString();
    }
    
    /*
     * Iterate recursively over the nums till 1 and return the list with value 1.
     * 
     * Now multiply the current value with return value and return the new generated arrayList. 
     */
    private List<Integer> factorial(int num) {
        if(num == 1) {
        	final List<Integer> list = new ArrayList<Integer>();
        	list.add(1);
        	return list;
        };
        
        List<Integer> result = factorial(num - 1);
        int carry = 0;
        for(int i = 0; i < result.size() ; i++) {
        	int current = (result.get(i) * num) + carry;
        	carry = 0;
        	if(current > 9) {
        		int remainder = current % 10;
    			result.set(i, remainder);
        		carry = current / 10;
        	} else {
        		result.set(i, current);
        	}
        }
        while(carry != 0) {
        	result.add(carry % 10);
        	carry = carry / 10;
        }
        return result;
    } 	

}
