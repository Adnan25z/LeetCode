class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from right to left
        while (i >= 0 || j >= 0) {
            int sum = carry;

            // Add the digits from a and b if they are available
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Compute the current digit (sum % 2) and carry (sum / 2)
            result.append(sum % 2);
            carry = sum / 2;
        }

        // If there's a remaining carry, append it
        if (carry != 0) {
            result.append(carry);
        }

        // Since we built the result from least significant to most significant bit, reverse it
        return result.reverse().toString();
    }
}
