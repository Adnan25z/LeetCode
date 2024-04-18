class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // Step 1: Initialize the queue with all rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0}); // Also track minutes with each orange
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // BFS process
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 4-directional vectors
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], minute = current[2];
            minutes = minute;
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2; // Rot the orange
                    queue.offer(new int[]{nx, ny, minute + 1});
                    freshCount--; // Decrease fresh orange count
                }
            }
        }
        
        // Step 3: Check if any fresh oranges are left
        return freshCount == 0 ? minutes : -1;
    }
}
