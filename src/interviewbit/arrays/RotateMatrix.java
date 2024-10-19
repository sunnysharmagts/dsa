package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

	public static void main(String[] args) {
		var obj = new RotateMatrix();
		var list = new ArrayList<ArrayList<Integer>>();
		list.add(new ArrayList<>(Arrays.asList(1,2,3)));
		list.add(new ArrayList<>(Arrays.asList(4,5,6)));
		list.add(new ArrayList<>(Arrays.asList(7,8,9)));
		obj.rotate(list);
		System.out.println(list);
	}
	
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        for(int i = 0; i < a.size(); i++) {
        	for(int j = i; j < a.size(); j++) {
        		int temp1 = a.get(i).get(j);
        		int temp2 = a.get(j).get(i);
        		a.get(i).set(j, temp2);
        		a.get(j).set(i, temp1);
        	}
        }
        
        for(int i = 0; i < a.size(); i++) {
        	int start = 0;
        	int end = a.size() - 1;
        	List<Integer> row = a.get(i);
        	while(start < end) {
        		int temp = row.get(start);
        		row.set(start, row.get(end));
        		row.set(end, temp);
        		start++;
        		end--;
        	}
        }
	}	

}
