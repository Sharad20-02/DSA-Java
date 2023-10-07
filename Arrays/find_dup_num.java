// https://leetcode.com/problems/find-the-duplicate-number/

package Arrays;

public class find_dup_num {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            if(res[nums[i]] == 1){
                return nums[i];
            }
            res[nums[i]]++;
        } 
        return 0;
    }
}
