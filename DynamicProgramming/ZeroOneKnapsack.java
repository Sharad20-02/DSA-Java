package DynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for(int i=0; i<n; i++){
            values[i] = scn.nextInt();
        }
        for(int i=0; i<n; i++){
            weights[i] = scn.nextInt();
        }

        int maxWeight = scn.nextInt();

        int[][] dp = new int[n+1][maxWeight+1];

        for(int i=1; i<dp.length; i++){
            int weight = weights[i-1];
            int value = values[i-1];
            for(int j=1; j<dp[0].length; j++){
                if(j >= weight){
                    dp[i][j] = Math.max(dp[i-1][j], value + dp[i-1][j-weight]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("Maximum value=" + dp[n][maxWeight]);
    }
}