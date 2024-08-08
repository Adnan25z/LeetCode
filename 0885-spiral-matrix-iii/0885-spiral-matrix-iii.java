class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int totalCells = rows * cols;
        int[][] result = new int[totalCells][2];
        int index = 0;

        // Directions: East, South, West, North
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int steps = 1; // Initial step size
        int direction = 0; // Start by moving east

        result[index++] = new int[]{rStart, cStart};

        while (index < totalCells) {
            for (int i = 0; i < 2; i++) { // Each loop covers 2 directions (East, South) or (West, North)
                for (int j = 0; j < steps; j++) {
                    rStart += dr[direction];
                    cStart += dc[direction];

                    // Check if the new position is within bounds
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[index++] = new int[]{rStart, cStart};
                    }
                }
                direction = (direction + 1) % 4; // Change direction
            }
            steps++; // Increase steps after covering two directions
        }

        return result;
    }
}