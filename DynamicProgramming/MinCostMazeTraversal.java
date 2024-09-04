package DynamicProgramming;

import java.util.Scanner;

public class MinCostMazeTraversal {
    public static void main(String[] args) {
        int n;
        int m;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        for(int row = n-1; row>=0; row--){
            for(int col=m-1; col>=0; col--){
                if(row == n-1 && col == m-1){
                    dp[row][col] = arr[row][col];
                }else if(row == n-1){
                    dp[row][col] = dp[row][col+1] + arr[row][col];
                }else if(col == m-1){
                    dp[row][col] = dp[row+1][col] + arr[row][col];
                }else{
                    dp[row][col] = Math.min(dp[row+1][col], dp[row][col+1]) + arr[row][col];
                }
            }
        }
        System.out.println("Minimum Cost Path=" + dp[0][0]);
    }
}
