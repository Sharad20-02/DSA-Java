package DynamicProgramming;

import java.util.Scanner;

public class PartitionIntoSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        int[][] dp = new int[k+1][n+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = 0;
                }else if(j == 0){
                    dp[i][j] = 0;
                }else if(i == j){
                    dp[i][j] = 1;
                }else if(i > j){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = (i*dp[i][j-1]) + dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[k][n]);
    }
}
