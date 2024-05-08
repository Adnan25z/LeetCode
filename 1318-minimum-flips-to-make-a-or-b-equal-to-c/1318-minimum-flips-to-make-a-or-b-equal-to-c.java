class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        for (int i = 0; i < 31; i++) {
            int bitA = (a >> i) & 1; // Extract i-th bit of a
            int bitB = (b >> i) & 1; // Extract i-th bit of b
            int bitC = (c >> i) & 1; // Extract i-th bit of c
            
            if (bitC == 0) {
                // Both must be 0
                flips += bitA + bitB; // Add 1 for each bit that is 1
            } else {
                // At least one must be 1
                if (bitA == 0 && bitB == 0) {
                    flips += 1; // Flip one of a or b to 1
                }
            }
        }
        return flips;
    }
}
