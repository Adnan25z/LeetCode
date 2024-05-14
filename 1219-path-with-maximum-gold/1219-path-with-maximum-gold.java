class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        
        int currentGold = grid[i][j];
        grid[i][j] = 0; // mark the cell as visited by setting it to 0
        int maxGold = 0;
        // explore all four directions
        maxGold = Math.max(maxGold, dfs(grid, i + 1, j));
        maxGold = Math.max(maxGold, dfs(grid, i - 1, j));
        maxGold = Math.max(maxGold, dfs(grid, i, j + 1));
        maxGold = Math.max(maxGold, dfs(grid, i, j - 1));
        
        grid[i][j] = currentGold; // backtrack, reset the cell
        return currentGold + maxGold;
    }
}
