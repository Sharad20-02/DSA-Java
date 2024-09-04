package DynamicProgramming;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int targetSum;
        targetSum = scn.nextInt();

        boolean[][] dp = new boolean[n+1][targetSum+1];

        for(int row=0; row<dp.length; row++){
            for(int col=0; col<dp[0].length; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = true;
                }else if(row == 0){
                    dp[row][col] = false;
                }else if(col == 0){
                    dp[row][col] = true;
                }else{
                    if(dp[row-1][col] == true){
                        dp[row][col] = true;
                    }else{
                        int val = arr[row-1];
                        if(col >= val){
                            if(dp[row-1][col - val] == true){
                                dp[row][col] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][targetSum]);
    }
}