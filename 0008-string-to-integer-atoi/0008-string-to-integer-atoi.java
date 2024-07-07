public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0, n = s.length();
        // Step 1: Ignore leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for sign
        int sign = 1;
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert number
        int result = 0;
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow and underflow before adding the digit
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        // Step 4: Return the result with the correct sign
        return result * sign;
    }
}