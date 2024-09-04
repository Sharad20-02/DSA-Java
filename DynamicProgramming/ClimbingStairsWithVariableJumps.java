package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsWithVariableJumps {
    public static void main(String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int res = CountPaths(n, arr);
        System.out.println("PathsCount=" + res);
    }

    public static int CountPaths(int n, int[] arr){
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=arr[i]; j++){
                if(i+j > n){
                    dp[i] += 0;
                }else{
                    dp[i] += dp[i+j];
                }
            }
        }
        return dp[0];
    }
}
