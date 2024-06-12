class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        // Initialize the first element of the row
        row.add(1);
        
        // Use iterative method to build up to the rowIndex-th row
        for (int i = 1; i <= rowIndex; i++) {
            // We are using only one list and updating it in place
            // Update from the end to start to avoid overwriting the values
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // Append 1 at the end of the row
            row.add(1);
        }
        
        return row;
    }
}