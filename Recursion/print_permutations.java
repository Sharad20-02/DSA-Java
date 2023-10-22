package Recursion;

public class print_permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] res = new int[nums.length];
        boolean[] used = new boolean[nums.length];
        printPermutations(nums, res, used, 0);
    }
    public static void printPermutations(int[] ques, int[] ans, boolean[] used, int idx){
        if(idx == ques.length){
            for(int num : ans){
                System.out.print(num + "  ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<ques.length; i++){
            if(used[i] == false){
                int num = ques[i];
                ans[idx] = num;
                used[i] = true;
                printPermutations(ques, ans, used, idx+1);
                used[i] = false;
            }
        }
    }
}