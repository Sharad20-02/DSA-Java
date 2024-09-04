package DynamicProgramming;

import java.util.Scanner;

public class CoinChangePermutation {
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

        for(int i=1; i<dp.length; i++){
            for(int j=0; j<arr.length; j++){
                int val = arr[j];
                if(i-val>=0 && dp[i-val] != 0){
                    dp[i] += dp[i-val];
                }
            }
        }
        System.err.println("Coin Permutations=" + dp[targetSum]);
    }
}
