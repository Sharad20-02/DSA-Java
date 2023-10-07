// https://leetcode.com/problems/find-all-duplicates-in-an-array/

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class find_all_dups_array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int n = Math.abs(nums[i]);

            if(nums[n-1] < 0){
                result.add(n);
            }
            else{
                nums[n-1] *= -1;
            }
        }
        return result;
    }
}
