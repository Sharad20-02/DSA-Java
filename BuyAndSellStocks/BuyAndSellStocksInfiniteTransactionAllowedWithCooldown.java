package BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionAllowedWithCooldown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;

        for(int i=1; i<n; i++){
            int nbsp = Math.max(obsp, ocsp - arr[i]);
            int nssp = Math.max(ossp, obsp + arr[i]);
            int ncsp = Math.max(ocsp, ossp);

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        System.out.println(ossp);
    }
}
