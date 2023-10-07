// https://leetcode.com/problems/combination-sum/

package Arrays;

import java.util.ArrayList;
import java.util.List;

public class combination_sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> helper = new ArrayList<>();
        findAns(0, target, candidates, ans, helper);
        return ans;
    }

    private void findAns(int index, int target, int[] arr, List<List<Integer>> ans, List<Integer> helper){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(helper));
            }
            return;
        }

        if(arr[index] <= target){
            helper.add(arr[index]);
            findAns(index, target - arr[index], arr, ans, helper);
            helper.remove(helper.size() - 1);
        }
        findAns(index+1, target, arr, ans, helper);
    }
}
