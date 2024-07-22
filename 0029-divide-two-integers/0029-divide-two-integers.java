class Solution {
    public int divide(int dividend, int divisor) {
        // Edge cases
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero.");
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Handle overflow
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long to handle overflow cases
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Result to store the quotient
        int result = 0;

        while (absDividend >= absDivisor) {
            long temp = absDivisor;
            int multiple = 1;
            while (absDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            absDividend -= temp;
            result += multiple;
        }

        return isNegative ? -result : result;
    }
}