class Solution {
    public int equalPairs(int[][] grid) {
    int n = grid.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        outerLoop:
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (grid[i][k] != grid[k][j]) {
                    continue outerLoop; // If any element doesn't match, skip to the next column
                }
            }
            count++; // If we didn't skip, the row and column match
        }
    }
    
    return count;
}
}