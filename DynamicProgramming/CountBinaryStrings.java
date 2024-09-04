package DynamicProgramming;

import java.util.Scanner;

public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        if(n == 0){
            System.out.println("Number of Binary Strings=" + 0);
            return;
        }

        int prevOne = 1;
        int prevZero = 1;


        for(int i=2; i<=n; i++){
            int currOne = prevOne + prevZero;
            int currZero = prevOne;

            prevOne = currOne;
            prevZero = currZero;
        }
        int res = prevOne + prevZero;
        System.out.println("Number of Binary Strings=" + res);
    }
}
