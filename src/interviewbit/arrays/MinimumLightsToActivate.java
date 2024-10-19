package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumLightsToActivate {

	public static void main(String[] args) {
		var obj = new MinimumLightsToActivate();
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 0, 0, 1)), 3));
		
		
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(1, 1, 1, 1)), 3));
		
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 1)), 1));
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0)), 4));
		
		System.out.println(obj.solve(new ArrayList<>(Arrays.asList(1, 1, 1)), 6));
		
	}
	
	//(0, 4), (1,5), (2, 6)   (5, 7)
	
	
/*
 * STATUS - REJECTED
 * 
 * Couldn't find the solution. Had to look for it.
 */
	
	public int solve(ArrayList<Integer> A, int B) {
		
		int i = 0;
		int minLights = 0;
		while(i < A.size()) {
			int start = Math.max((i - B + 1), 0);
			int end = Math.min(i + B - 1, A.size() - 1);
			boolean foundLight = false;
			while(end >= start) {
				if(A.get(end) == 1) {
					foundLight = true;
					minLights++;
					i = end + B - 1; 
					break;
				}
				end--;
				
			}
			if(!foundLight) {
				return -1;
			}
			i++;
		}
		return minLights;
	}

/*
 * 	This looked like a range question.
 * 
 * Start from the end and check 
 */
	public int solve1(ArrayList<Integer> A, int B) {
    	
    	int i = A.size() - 1;
    	while(i >= 0 && A.get(i) != 1) {
    		i--;
    	}
    	if(i < 0) return -1;
    	int[] lastLight = new int[] {Math.max(0, (i - B) + 1), Math.min(i + B - 1, A.size() - 1)};
    	if(lastLight[1] < A.size() - 1) return -1;
    	if(lastLight[0] == 0 && lastLight[1] == A.size()-1) return 1;
    	
    	int minLights = 1;
    	i--;
    	while(i >= 0) {
    		if(A.get(i) == 1) {
	    		minLights++;
	    		int[] currentLight = new int[] {Math.max(0, (i - B) + 1), Math.min(i + B - 1, A.size() - 1)};
	    		if(currentLight[0] == 0 && currentLight[1] == A.size() - 1) return 1;
	    		lastLight = new int[] {Math.min(lastLight[0], currentLight[0]), Math.max(lastLight[1], currentLight[1])};
	    		if(lastLight[0] == 0 && lastLight[1] == A.size() - 1) return minLights;
    		}
    		i--;
    	}
    	return lastLight[0] == 0 && lastLight[1] == A.size() - 1 ? minLights : -1;
	}	
}
