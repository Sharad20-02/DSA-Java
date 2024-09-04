package DynamicProgramming;

import java.util.Scanner;

public class DecodeWays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        int[] dp = new int[str.length()];
        dp[0] = 1;

        for(int i=1; i<dp.length; i++){
            char im1Char = str.charAt(i-1);
            char iChar = str.charAt(i);

            if(im1Char == '0' && iChar == '0'){
                dp[i] = 0;
            }else if(im1Char == '0' && iChar != '0'){
                dp[i] = dp[i-1];
            }else if (im1Char != '0' && iChar == '0'){
                if(im1Char == '1' || im1Char == '2'){
                    dp[i] = i>=2 ? dp[i-2] : 1;
                }else{
                    dp[i] = 0;
                }
            }else{
                if(Integer.parseInt(str.substring(i-1, i+1)) <= 26){
                    dp[i] = dp[i-1] + (i>=2 ? dp[i-2] : 1);
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        System.out.println(dp[str.length()-1]);
    }
}
