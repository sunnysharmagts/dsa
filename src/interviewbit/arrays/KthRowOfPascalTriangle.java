package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class KthRowOfPascalTriangle {

	public static void main(String[] args) {
		var obj = new KthRowOfPascalTriangle();
//		System.out.println(obj.getRow(1));
//		System.out.println(obj.getRow(0));
//		System.out.println(obj.getRow(3));
//		System.out.println(obj.getRow(5));
		
		System.out.println(obj.solve(3));
		System.out.println(obj.solve(5));		
	}
	
    public ArrayList<Integer> getRow(int A) {
    	if(A == 0) {
    		final ArrayList<Integer> list = new ArrayList<Integer>();
    		list.add(1);
    		return list;
    	}
    	ArrayList<Integer> resp = getRow(A - 1);
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	for(int i = 0; i <= A; i++) {
    		result.add(1);
    	}
    	for(int i = 1; i <= A - 1; i++) {
    		int sum = resp.get(i) + resp.get(i-1);
    		result.set(i, sum);
    	}
    	return result;
    }
    
    public ArrayList<ArrayList<Integer>> solve(int A) {
    	final ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
    	result.add(solve(A, result));
    	return result;
    }
    
    private ArrayList<Integer> solve(int i, ArrayList<ArrayList<Integer>> result) {
    	if(i == 0) {
    		final ArrayList<Integer> list = new ArrayList<Integer>();
    		list.add(1);
    		return list;
    	}
    	final ArrayList<Integer> list = solve(i - 1, result);
    	result.add(list);
    	final ArrayList<Integer> newList = new ArrayList<Integer>();
    	for(int j = 0; j <= i; j++) {
    		newList.add(1);
    	}
    	for(int j = 1; j <= i - 1; j++) {
    		int sum = list.get(j) + list.get(j-1);
    		newList.set(j, sum);
    	}
    	return newList;
    }
}
