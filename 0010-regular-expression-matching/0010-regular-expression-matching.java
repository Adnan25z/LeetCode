class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty pattern matches empty string
        dp[0][0] = true;

        // Initialize dp for patterns that can match an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // '*' matches zero or more of the preceding element
                    dp[i][j] = dp[i][j - 2] || (matches(s, p, i, j - 1) && dp[i - 1][j]);
                } else {
                    // Direct match or '.' match
                    dp[i][j] = matches(s, p, i, j) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}