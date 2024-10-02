class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x; // Base cases for 0 and 1
        
        int left = 1, right = x, result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;  // To avoid overflow
            long midSquared = (long) mid * mid;   // Use long to avoid overflow
            
            if (midSquared == x) {
                return mid;  // Perfect square
            } else if (midSquared < x) {
                result = mid;  // Store the closest lower value
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;  // Return the closest integer value
    }
}
