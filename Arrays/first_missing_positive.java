// https://leetcode.com/problems/first-missing-positive/

package Arrays;

public class first_missing_positive {
     public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] <=0 || nums[i] > n){
                nums[i] = 0;
            }
        }

        for(int i=0; i<n; i++){
            while(nums[i]!=0 && nums[i]!=i+1){
                if(nums[i] == nums[nums[i]-1]){
                    break;
                }
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i=0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;

     
}
void swap(int[] nums, int i, int j) 
	{
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}