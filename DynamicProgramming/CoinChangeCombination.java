package DynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int targetSum = scn.nextInt();

        int[] dp = new int[targetSum+1];
        dp[0] = 1;

        for(int i=0; i<n; i++){
            int val = arr[i];
            for(int j=val; j<dp.length; j++){
                if(dp[j-val] != 0){
                    dp[j] += dp[j-val];
                }
            }
        }
        System.out.println("Number of Combinations=" + dp[targetSum]);
    }
}