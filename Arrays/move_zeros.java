// https://leetcode.com/problems/move-zeroes/

package Arrays;

public class move_zeros {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int zeroCount = 0;
        int j = 0;
        for(int i=0; i<size ;i++){
            if(nums[i] == 0){
                zeroCount += 1;
                continue;
            }
            nums[j++] = nums[i];
        }
        while(zeroCount >0 ){
            nums[j++] = 0;
            zeroCount -= 1;
        }
    }
}
