package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n;
        Scanner scn = new Scanner(System.in);
        // n = scn.nextInt();
        n = 10;
        int res = CountPaths(n);
        System.out.println(res);
        System.out.println("------------------------");
        int resMemoized = CountPathsMemoized(n, new int[n+1]);
        System.out.println(resMemoized);
        System.out.println("------------------------");
        int resTabulation = CountPathsTabulation(n);
        System.out.println(resTabulation);
    }

    public static int CountPaths(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        System.out.println("Hello" + n);
        int nm1 = CountPaths(n-1);
        int nm2 = CountPaths(n-2);
        int nm3 = CountPaths(n-3);
        int cp = nm1 + nm2 + nm3;
        return cp;
    }

    public static int CountPathsMemoized(int n, int[] qb){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(qb[n] != 0){
            return qb[n];
        }
        System.out.println("Hello" + n);
        int nm1 = CountPathsMemoized(n-1, qb);
        int nm2 = CountPathsMemoized(n-2, qb);
        int nm3 = CountPathsMemoized(n-3, qb);
        int cp = nm1 + nm2 + nm3;
        qb[n] = cp;
        return cp;
    }

    public static int CountPathsTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = dp[0];
        dp[2] = dp[0] + dp[1];
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}