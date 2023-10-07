// https://leetcode.com/problems/pascals-triangle/

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows <= 0){
            return triangle;
        }

        for(int i=0; i<numRows; i++){
            List<Integer> row = new ArrayList<Integer>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    row.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
