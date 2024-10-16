package interviewbit.arrays;

import java.util.ArrayList;

public class SpiralOrderMatrixII {

	public static void main(String[] args) {
		var obj = new SpiralOrderMatrixII();
		System.out.println(obj.generateMatrix(2));
		System.out.println(obj.generateMatrix(3));
		System.out.println(obj.generateMatrix(5));
	}
	
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        
        int top = 0;
        int bottom = A - 1;
        int left = 0;
        int right = A - 1;
        int nums = 1;
        int[][] matrix = new int[A][A];
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix.length; j++) {
        		matrix[i][j] = nums++;
        	}
        }
        
        int direction = 0;
        final ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        while(top <= bottom && left <= right) {
            if(direction == 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                if(!list.isEmpty()) result.add(list);
                top++;
            }
            else if(direction == 1) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                if(!list.isEmpty()) result.add(list);
                right--;                
            }
            else if(direction == 2) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                if(!list.isEmpty()) result.add(list);
                bottom--;                
            }
            else if(direction == 3) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
                if(!list.isEmpty()) result.add(list);
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }	

}
