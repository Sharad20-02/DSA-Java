package BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStocksOneTransactionAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int min = arr[0];
        int maxProfit = 0;

        for(int i=1; i<n; i++){
            if(arr[i] < min){
                min = arr[i];
                maxProfit = Math.max(maxProfit, 0);
            }else{
                maxProfit = Math.max(maxProfit, arr[i]-min);
            }
        }
        System.out.println(maxProfit);
    }
}
