class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    // Calculate box index
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    
                    // Check for duplicates in rows, columns and boxes
                    if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                        return false;
                    }
                    
                    // Add the number to the sets
                    rows[i].add(num);
                    cols[j].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }
        
        return true;
    }
}