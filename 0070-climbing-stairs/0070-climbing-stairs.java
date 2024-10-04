class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;  // Base case for 1 step
        if (n == 2) return 2;  // Base case for 2 steps
        
        int[] dp = new int[n + 1];
        dp[1] = 1;  // 1 way to reach the 1st step
        dp[2] = 2;  // 2 ways to reach the 2nd step
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];  // The recurrence relation
        }
        
        return dp[n];  // The answer is stored at dp[n]
    }
}
