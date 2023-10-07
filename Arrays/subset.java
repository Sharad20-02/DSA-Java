// https://leetcode.com/problems/subsets/
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return result;
        }

        subsets(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }

    private void subsets(int[] nums, ArrayList<Integer> temp, int index, List<List<Integer>> result){
        // base condition
        if(index >= nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[index]);
        subsets(nums, temp, index+1, result);

        temp.remove(temp.size() - 1);
        subsets(nums, temp, index+1, result);
    }
}
