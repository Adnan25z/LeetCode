class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;  // Edge case handling
        }

        int max1 = -1, max2 = -1; // max1 is the largest, max2 is the second largest
        int maxIndex = -1;

        // Traverse the array to find the largest and second largest elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max2 = max1;  // Update max2 to the old max1
                max1 = nums[i];  // Update max1 to the current element
                maxIndex = i;  // Update the index of the largest element
            } else if (nums[i] > max2) {
                max2 = nums[i];  // Update max2 if the current element is the second largest
            }
        }

        // Check if the largest element is at least twice as large as the second largest
        if (max1 >= 2 * max2) {
            return maxIndex;
        } else {
            return -1;
        }
    }
}