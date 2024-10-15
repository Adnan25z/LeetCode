class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Start from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case: All characters in the word are matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and if the current cell matches the word character
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited by temporarily modifying the board
        char temp = board[row][col];
        board[row][col] = '#'; // Mark this cell as visited

        // Explore in all four possible directions (up, down, left, right)
        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                        backtrack(board, word, row - 1, col, index + 1) ||
                        backtrack(board, word, row, col + 1, index + 1) ||
                        backtrack(board, word, row, col - 1, index + 1);

        // Backtrack by restoring the cell
        board[row][col] = temp;

        return found;
    }
}
