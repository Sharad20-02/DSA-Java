// https://leetcode.com/problems/3sum/

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List <List<Integer>> arr = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            int target = -a;
            int s= i+1;
            int e = nums.length - 1;
            while(s<e){
                if(nums[s] + nums[e] == target){
                    arr.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    while(s<e && nums[s]==nums[s+1]){
                        s++;
                    }
                    while(s<e && nums[e]==nums[e-1]){
                        e--;
                    }
                    s++;
                    e--;
                }
                else if(nums[s] + nums[e] > target){
                    e--;
                }
                else{
                    s++;
                }
            }
            while(i+1 < nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return arr;
    }
}
