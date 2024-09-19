public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end is an obstacle, there are no possible paths.
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        // Initialize the dp array with size m x n
        int[][] dp = new int[m][n];

        // Set the starting point
        dp[0][0] = 1;

        // Fill the first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j-1];  // If no obstacle, propagate the value from the left.
            } else {
                dp[0][j] = 0;  // Obstacle blocks further paths.
            }
        }

        // Fill the first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i-1][0];  // If no obstacle, propagate the value from above.
            } else {
                dp[i][0] = 0;  // Obstacle blocks further paths.
            }
        }

        // Fill the rest of the dp array
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];  // Sum paths from above and from left
                } else {
                    dp[i][j] = 0;  // If it's an obstacle, no paths go through this cell.
                }
            }
        }

        // The answer is the number of paths to the bottom-right corner
        return dp[m-1][n-1];
    }
}
