class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // Initialize a 1D DP array
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: dp[0] = 1

        // Fill DP array
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n];
    }
}
