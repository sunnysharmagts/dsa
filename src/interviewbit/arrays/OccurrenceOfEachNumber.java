package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class OccurrenceOfEachNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 * Since we need to find the occurrence, for that we need a map to store the count.
	 * 
	 * Once that is done, we need to sort the map based on count.
	 * 
	 * In case if count is same then we need sort them based on the key. This can be done in multiple ways
	 * 
	 * I would be taking a priority queue of int[] and sort based on that.
	 * 
	 * If array provided is null or empty then return an empty list as a result.
	 */
    public ArrayList<Integer> findOccurences(ArrayList<Integer> A) {
    	final ArrayList<Integer> result = new ArrayList<Integer>();
    	if(A == null || A.isEmpty()) return result;
    	
    	final SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	
    	for(int nums : A) {
    		map.put(nums, map.getOrDefault(nums, 0) + 1);
    	}
    	for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
    		result.add(entry.getValue()); 
    	}
    	return result;
    }	

}
