class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0; // Base case: if there's only one person, they are the winner.

        // Iteratively apply the Josephus formula
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }

        // Convert from 0-based index to 1-based index
        return winner + 1;
        
    }
}