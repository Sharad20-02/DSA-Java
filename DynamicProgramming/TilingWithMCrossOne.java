package DynamicProgramming;

import java.util.Scanner;

public class TilingWithMCrossOne {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[] dp = new int[n+1];

        for(int i=1; i<m; i++){
            dp[i] = 1;
        }
        dp[m] = 2;
        for(int i=m+1; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-m];
        }

        System.out.println(dp[n]);
    }
}
