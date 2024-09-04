package DynamicProgramming;

import java.util.Scanner;

public class paintHouseManyColorsOptimized {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int houses = scn.nextInt();
        int colors = scn.nextInt();

        int[][] arr = new int[houses][colors];

        for(int i=0; i<houses; i++){
            for(int j=0; j<colors; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[houses][colors];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for(int i=0; i<colors; i++){
            dp[0][i] = arr[0][i];

            if(arr[0][i] <= least){
                sleast = least;
                least = arr[0][i];
            }else if(arr[0][i] <= sleast){
                sleast = arr[0][i];
            }
        }

        for(int i=1; i<houses; i++){
            int newleast = Integer.MAX_VALUE;
            int newsleast = Integer.MAX_VALUE;
            for(int j=0; j<colors; j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = sleast + arr[i][j];
                }else{
                    dp[i][j] = least + arr[i][j];
                }
                if(dp[i][j] <= newleast){
                    newsleast = newleast;
                    newleast = dp[i][j];
                }else if(dp[i][j] <= newsleast){
                    newsleast = dp[i][j];
                }
            }
            least = newleast;
            sleast = newsleast;
        }
        System.out.println(least);
    }
}
