class Solution {
    public int numTrees(int n) {
        // dp array where dp[i] represents the number of unique BSTs with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node tree
        
        // Fill the dp array using the recursive formula
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // dp[root - 1] * dp[nodes - root] is added for each root choice
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        
        // The result is the number of unique BSTs with n nodes
        return dp[n];
    }
}
