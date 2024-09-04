package DynamicProgramming;

import java.util.Scanner;

public class PaintHouseManyColors {
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

        for(int i=0; i<colors; i++){
            dp[0][i] = arr[0][i];
        }

        for(int i=1; i<houses; i++){
            for(int j=0; j<colors; j++){
                int prevHouseMin = getMinimum(j, i, dp);
                dp[i][j] = arr[i][j] + prevHouseMin;
            }
        }
        System.out.println(getMinimum(colors, houses, dp));
    }

    public static int getMinimum(int excludeIndex, int currentHouse, int[][] dp){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<dp[0].length; i++){
            if(i == excludeIndex){
                continue;
            }
            min = Math.min(min, dp[currentHouse-1][i]);
        }
        return min;
    }
}
