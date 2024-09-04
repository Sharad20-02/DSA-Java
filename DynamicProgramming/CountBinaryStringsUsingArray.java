package DynamicProgramming;

import java.util.Scanner;

public class CountBinaryStringsUsingArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if(n == 0){
            System.out.println("Number of Binary Strings=" + 0);
            return;
        }

        int[] dpz = new int[n+1];
        int[] dpo = new int[n+1];

        dpz[0] = 0;
        dpo[0] = 0;

        dpz[1] = 1;
        dpo[1] = 1;

        for(int i=2; i<=n; i++){
            dpz[i] = dpo[i-1];
            dpo[i] = dpo[i-1] + dpz[i-1];
        }

        int res = dpz[n] + dpo[n];
        System.out.println("Number of Binary Strings=" + res);
    }
}
