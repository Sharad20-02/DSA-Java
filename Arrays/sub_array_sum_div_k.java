// https://leetcode.com/problems/subarray-sums-divisible-by-k/

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class sub_array_sum_div_k {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        int rem = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            rem = sum%k;
            if(rem<0){
                rem += k;
            }
            if(hm.containsKey(rem)){
                res += hm.get(rem);
                hm.put(rem, hm.get(rem) + 1);
            }
            else{
                hm.put(rem, 1);
            }
        }
        return res;
    }
}