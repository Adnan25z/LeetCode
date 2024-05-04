class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;                  // Max profit if we do not hold any stock today
        int hold = -prices[0];         // Max profit if we hold one stock today (we buy on day 0)

        for (int i = 1; i < prices.length; i++) {
            int newCash = Math.max(cash, hold + prices[i] - fee); // Sell the stock today
            int newHold = Math.max(hold, cash - prices[i]);      // Buy the stock today
            cash = newCash;
            hold = newHold;
        }
        
        return cash; // Maximum profit will be when we do not hold any stock
    }
}
