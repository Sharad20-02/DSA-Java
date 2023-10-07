// https://leetcode.com/problems/majority-element/

package Arrays;

import java.util.Arrays;

public class majority_element {
     public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}
