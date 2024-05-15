import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> gridList) {
        int n = gridList.size();
        int[][] minDist = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the minDist array and queue with List<List<Integer>>
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
            List<Integer> row = gridList.get(i);
            for (int j = 0; j < n; j++) {
                if (row.get(j) == 1) {
                    minDist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Multi-source BFS for minimum distances
        int[] dirs = {0, 1, 0, -1, 0};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    if (minDist[nr][nc] > minDist[r][c] + 1) {
                        minDist[nr][nc] = minDist[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        // BFS to find the maximum minimum safeness factor path
        queue.offer(new int[]{0, 0});
        int[][] visited = new int[n][n];
        for (int[] row : visited) Arrays.fill(row, -1);
        visited[0][0] = minDist[0][0];
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dirs[d], nc = c + dirs[d + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newSafety = Math.min(visited[r][c], minDist[nr][nc]);
                    if (newSafety > visited[nr][nc]) {
                        visited[nr][nc] = newSafety;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return visited[n - 1][n - 1];
    }
}
