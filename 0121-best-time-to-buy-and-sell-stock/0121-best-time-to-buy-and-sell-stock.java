class Solution {
    public static int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) {
                return 0;
            }

            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            // Iterate over the prices
            for (int price : prices) {
                if (price < minPrice) {
                    minPrice = price;  // Update the minimum price
                } else if (price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;  // Update the maximum profit
                }
            }

            return maxProfit;
        }
}