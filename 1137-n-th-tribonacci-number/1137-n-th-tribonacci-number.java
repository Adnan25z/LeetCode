class Solution {
    public int tribonacci(int n) {
        // Base cases directly returned
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // Variables to store the last three computed Tribonacci numbers
        int trib_n_minus_3 = 0; // T0
        int trib_n_minus_2 = 1; // T1
        int trib_n_minus_1 = 1; // T2
        int trib_n = 0; // To store the current Tribonacci number
        
        // Start computing from T3 to Tn
        for (int i = 3; i <= n; i++) {
            // Current Tribonacci number is the sum of the previous three
            trib_n = trib_n_minus_3 + trib_n_minus_2 + trib_n_minus_1;
            // Shift the last three numbers for the next iteration
            trib_n_minus_3 = trib_n_minus_2;
            trib_n_minus_2 = trib_n_minus_1;
            trib_n_minus_1 = trib_n;
        }
        
        return trib_n;
    }
}
