// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

package Arrays;

public class buy_sell_stock_2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
