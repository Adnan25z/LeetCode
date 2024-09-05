class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = nums[0]; // Initialize to the first element, in case all elements are negative
        
        for (int num : nums) {
            // Update the current sum: either start a new subarray or extend the existing one
            currentSum = Math.max(num, currentSum + num);
            // Update the max sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}