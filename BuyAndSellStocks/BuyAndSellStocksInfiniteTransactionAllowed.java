package BuyAndSellStocks;

import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] prices = new int[n];

        for(int i=0; i<n; i++){
            prices[i] = scn.nextInt();
        }

        int b = 0;
        int s = 0;
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i] >= prices[s]){
                s++;
            }else{
                maxProfit += prices[s] - prices[b];
                b = i;
                s = i;
            }
        }
        maxProfit += prices[s] - prices[b];
        System.out.println(maxProfit);
    }
}
