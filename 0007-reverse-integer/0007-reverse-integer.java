class Solution {
     public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int pop = x % 10;  // Extract the last digit
            x /= 10;  // Remove the last digit from x

            // Check for overflow/underflow before updating the reversed number
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;  // Overflow case for positive numbers
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;  // Underflow case for negative numbers
            }

            reversed = reversed * 10 + pop;  // Append the digit to the reversed number
        }

        return reversed;
    }
}