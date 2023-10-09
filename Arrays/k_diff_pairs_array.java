// https://leetcode.com/problems/k-diff-pairs-in-an-array/

package Arrays;

import java.util.HashMap;
import java.util.Map;

public class k_diff_pairs_array {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num : nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        int result = 0;

        for(int i : hm.keySet()){
            if( (k>0 && hm.containsKey(i+k)) || (k==0 && hm.get(i)>1) ){
                result++;
            }
        }
        return result;
    }
}