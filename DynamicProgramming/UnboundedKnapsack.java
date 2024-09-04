package DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {
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

        int[] dp = new int[maxWeight+1];

        for(int i=0; i<n; i++){
            int weight = weights[i];
            int value = values[i];
            for(int j=1; j<dp.length; j++){
                if(j >= weight){
                    dp[j] = Math.max(dp[j], value + dp[j-weight]);
                }
            }
        }
        System.out.println("Maximum Value=" + dp[maxWeight]);
    }
}
