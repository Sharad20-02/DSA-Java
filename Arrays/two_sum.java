package Arrays;
import java.util.*;
class two_sum {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> hm = new HashMap <Integer, Integer>();
        int size = nums.length;
        int[] res = new int[2];
        
        for(int i=0;i<size;i++){
            int x = nums[i];
            if(hm.get(target - x) != null){
                int y = hm.get(target - x);
                if(i == y){
                continue;
            }
            res[0] = i;
            res[1] = y;
            break;
            }
            hm.put(nums[i], i);
        }
        return res;
    }
}