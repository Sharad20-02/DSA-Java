// https://leetcode.com/problems/running-sum-of-1d-array/

package Arrays;

public class running_sum_1d_array {
    public int[] runningSum(int[] nums) {
        int size = nums.length;
        int sum = 0;
        int[] res = new int[size];
        for(int i=0; i<size; i++){
            sum = sum + nums[i];
            res[i] = sum;
        }
        return res;
    }
}
