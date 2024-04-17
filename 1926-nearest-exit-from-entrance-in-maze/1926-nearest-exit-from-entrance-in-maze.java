class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        maze[entrance[0]][entrance[1]] = '+'; // Marking the entrance as visited

        // Add the entrance to the queue with initial distance of 0
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], dist = current[2];

            // Explore in four directions
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.') {
                    // Check if it's an exit
                    if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                        return dist + 1;
                    }
                    maze[newRow][newCol] = '+'; // Mark as visited
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }
        }

        return -1; // No exit found
    }
}