// https://leetcode.com/problems/squares-of-a-sorted-array/

package Arrays;

public class square_sorted_array {
    public int[] sortedSquares(int[] nums) {
        int[] copy = new int[nums.length];

        int l = 0;
        int r = nums.length - 1;
        while(r>=l){
            if(Math.abs(nums[r]) > Math.abs(nums[l])){
                copy[r-l] = nums[r] * nums[r];
                r--;
            }else if(Math.abs(nums[l]) >= Math.abs(nums[r])){
                copy[r-l] = nums[l] * nums[l];
                l++;
            }
        }
        return copy;

    }

}
