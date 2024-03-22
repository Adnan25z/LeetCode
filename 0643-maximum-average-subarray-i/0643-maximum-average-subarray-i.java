class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double maxSum = sum;
        // Slide the window from left to right across 'nums'
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // Add the next element and remove the leftmost element from the sum
            maxSum = Math.max(maxSum, sum); // Update 'maxSum' if 'sum' is greater
        }
        
        // Divide 'maxSum' by 'k' to get the maximum average
        return maxSum / k;
    }
}
