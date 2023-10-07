// https://leetcode.com/problems/find-pivot-index/

package Arrays;

public class pivot_index {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        for(int i=1; i<nums.length; i++){
            rightSum += nums[i];
        }
        if(rightSum == 0){
            return 0;
        }
        int leftSum = 0;

        for(int i=1; i<nums.length; i++){
            rightSum -= nums[i];
            leftSum += nums[i-1];
            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}
