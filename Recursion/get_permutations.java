package Recursion;

import java.util.ArrayList;
import java.util.List;

public class get_permutations {
    class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans= new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permutations(nums, ans, used, 0, res);
        return res;
    }
    public static void permutations(int[] ques, List<Integer> ans, boolean[] used, int idx, List<List<Integer>> res){
        if(idx == ques.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0; i<ques.length; i++){
            if(used[i] == false){
                int num = ques[i];
                used[i] = true;
                ans.add(num);
                permutations(ques, ans, used, idx+1, res);
                used[i] = false;
                ans.remove(ans.size()-1);
            }
        }
    }
}   
}
