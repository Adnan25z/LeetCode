class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Check if lengths match for a possible interleaving
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        
        // DP array where dp[i][j] indicates if s3[0..i+j-1] is formed by interleaving
        // s1[0..i-1] and s2[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true; // Empty strings can form an empty interleaved string
        
        // Fill the dp array
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Check if the current character in s1 can match s3
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                // Check if the current character in s2 can match s3
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
