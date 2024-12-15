class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int n = prices.length;
        
        // Array to store the maximum profit achievable up to each day
        int[] leftProfit = new int[n];
        // Array to store the maximum profit achievable starting from each day
        int[] rightProfit = new int[n];
        
        // First pass: Calculate max profit for the first transaction
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], prices[i] - minPrice);
        }
        
        // Second pass: Calculate max profit for the second transaction
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - prices[i]);
        }
        
        // Combine the two profits to get the maximum result
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, leftProfit[i] + rightProfit[i]);
        }
        
        return maxProfit;
    }
}
