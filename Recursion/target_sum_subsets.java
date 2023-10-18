package Recursion;

public class target_sum_subsets {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int target = 60;
        targetSumSubsets(arr, target, 0, "", 0);
    }

    public static void targetSumSubsets(int[] arr, int target, int sum, String asf, int idx){
        if(idx == arr.length){
            if(sum == target){
                System.out.println(asf);
            }
            return;
        }
        targetSumSubsets(arr, target, sum+arr[idx], asf + arr[idx] + ", ", idx+1);
        targetSumSubsets(arr, target, sum, asf, idx+1);
    }
}
