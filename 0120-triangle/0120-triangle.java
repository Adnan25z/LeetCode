class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // Create a DP array to store the minimum path sums
        int[] dp = new int[n];

        // Initialize the DP array with the last row of the triangle
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Iterate from the second-to-last row to the top
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Update the DP array with the minimum path sum for each element
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // The top element contains the minimum path sum
        return dp[0];
    }
}
