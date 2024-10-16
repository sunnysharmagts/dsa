package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSquareSubMatrix {

	public static void main(String[] args) {
		var obj = new MaximumSumSquareSubMatrix();
		var list = new ArrayList<ArrayList<Integer>>();
		list.add((new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1))));
		list.add((new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2))));
		list.add((new ArrayList<Integer>(Arrays.asList(3, 8, 6, 7, 3))));
		list.add((new ArrayList<Integer>(Arrays.asList(4, 4, 4, 4, 4))));
		list.add((new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5))));
		System.out.println(obj.solve(list, 3));

//		list = new ArrayList<ArrayList<Integer>>();
//		list.add((new ArrayList<Integer>(Arrays.asList(2,2))));
//		list.add((new ArrayList<Integer>(Arrays.asList(2,2))));
//		System.out.println(obj.solve(list, 2));		
	}

	/*
	 * STATUS - REJECTED
	 * 
	 * PROBLEM - Taking lot of time to visualize traversal in matrix.
	 * 
	 * Took 1+ hr to do the dry run of the code and write pseude code.
	 * 
	 * Positive. The solution ran in one shot and i solved the problem without looking at any solution or hint.
	 * 
	 * Time complexity O(m * n) 
	 * 
	 * Space complexity O((M * N) - B + 1) * (M * N) - B + 1)  used for caching
	 * 
	 */
	public int solve(ArrayList<ArrayList<Integer>> A, int B) {
		if (A == null || A.isEmpty() || B > A.size()) {
			return 0;
		}
		int startRow = 0;
		int endRow = B - 1;
		int startCol = 0;
		int endCol = B - 1;

		int max = Integer.MIN_VALUE;

		int length = A.size() - B + 1;
		int[][] cache = new int[length][length];
		int currentStartRow = startRow;
		int currentEndRow = endRow;
		for (int c = 0; c < cache.length; c++) {
			int current = 0;
			if (c == 0) {
				for (int i = currentStartRow; i <= currentEndRow; i++) {
					for (int j = startCol; j <= endCol; j++) {
						current += A.get(i).get(j);
					}
				}
			} else {
				current = cache[c - 1][0];
				for (int i = startCol; i <= endCol; i++) {
					current += A.get(currentEndRow).get(i);
					current -= A.get(currentStartRow - 1).get(i);
				}
			}
			cache[c][0] = current;
			max = Math.max(current, max);
			currentStartRow++;
			currentEndRow++;
		}
		startCol++;
		endCol++;
		for (int i = 0; i < cache.length; i++) {
			int currentStartCol = startCol;
			int currentEndCol = endCol;
			int j = 1;
			int current = cache[i][j - 1];
			currentStartRow = startRow;
			currentEndRow = endRow;
			while (currentEndCol < A.get(0).size()) {
				for (int x = currentStartRow; x <= currentEndRow; x++) {
					current += A.get(x).get(currentEndCol);
					current -= A.get(x).get(currentStartCol - 1);
				}
				max = Math.max(current, max);
				cache[i][j++] = current;
				currentStartCol++;
				currentEndCol++;
			}
			startRow++;
			endRow++;
		}
		return max;
	}
}
