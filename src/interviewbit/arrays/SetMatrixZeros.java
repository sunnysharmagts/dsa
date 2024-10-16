package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {

	public static void main(String[] args) {
		var obj = new SetMatrixZeros();
		final var list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<>(Arrays.asList(0,0)));
		list.add(new ArrayList<>(Arrays.asList(1,0)));
		obj.setZeroes(list);
		System.out.println(list);
	}
	
	/*
	 * Status - REJECTED
	 * 
	 * Tried first by traversing the array and setting non-zero values to -1 if that row / col value is zero
	 * 
	 * this takes n^3. I miscalculated the extra n as we would be rewriting everytime i get another 0 in the same row or column.
	 * 
	 * Secondly, i saw a hint and did this by caching data.
	 * 
	 * O(2 * (m * n)) time complexity and O(M + N) 
	 */
	public void setZeroesWithAux(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.isEmpty()) return;
        
        boolean[] row = new boolean[a.size()];
        boolean[] col = new boolean[a.get(0).size()];
        
        for(int i = 0; i < a.size(); i++) {
        	for(int j = 0; j < a.get(0).size(); j++) {
        		if(a.get(i).get(j) == 0) {
        			row[i] = true;
        			col[j] = true;
        		}
        	}
        }
        
        for(int i = 0; i < a.size(); i++) {
        	for(int j = 0; j < a.get(0).size(); j++) {
        		if(row[i] || col[j]) {
        			a.get(i).set(j, 0);
        		}
        	}
        }        
	}
	
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if(a == null || a.isEmpty()) return;
        
        boolean hasZeroInRow = false;
        boolean hasZeroInCol = false;
        boolean isZeroRowCol = a.get(0).get(0) == 0 ? true : false;
        
        for(int row = 1; row < a.size(); row++) {
        	if(a.get(row).get(0) == 0) {
        		hasZeroInCol = true;
        		break;
        	}
        }
        
        for(int col = 1; col < a.get(0).size(); col++) {
        	if(a.get(0).get(col) == 0) {
        		hasZeroInRow = true;
        	}
        }
        
        for(int i = 1; i < a.size(); i++) {
        	for(int j = 1; j < a.get(0).size(); j++) {
        		if(a.get(i).get(j) == 0) {
        			a.get(i).set(0, 0);
        			a.get(0).set(j, 0);
        		}
        	}
        }
        
        for(int i = 1; i < a.size(); i++) {
        	for(int j = 1; j < a.get(0).size(); j++) {
        		if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
        			a.get(i).set(j, 0);
        		}
        	}
        }
        
        if(hasZeroInRow || isZeroRowCol) {
        	for(int i = 0; i < a.get(0).size(); i++) {
        		a.get(0).set(i, 0);
        	}
        }
        
        if(hasZeroInCol || isZeroRowCol) {
        	for(int i = 0; i < a.size(); i++) {
        		a.get(i).set(0, 0);
        	}
        }        
	}	

}
