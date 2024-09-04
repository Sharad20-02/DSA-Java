package DynamicProgramming;

import java.util.Scanner;

public class GoldMine {
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

        for(int col=m-1; col>=0; col--){
            for(int row=n-1; row>=0; row--){
                if(col == m-1){
                    dp[row][col] = arr[row][col];
                }else if(row == n-1){
                    dp[row][col] = Math.max(dp[row][col+1], dp[row-1][col+1]) + arr[row][col];
                }else if(row == 0){
                    dp[row][col] = Math.max(dp[row][col+1], dp[row+1][col+1]) + arr[row][col];
                }else{
                    dp[row][col] = Math.max(dp[row-1][col+1], Math.max(dp[row][col+1], dp[row+1][col+1])) + arr[row][col];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i][0]);
        }
        System.out.println("Max Gold=" + max);
    }
}
