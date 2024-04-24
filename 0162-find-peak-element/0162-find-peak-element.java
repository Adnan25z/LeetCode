class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { // Continue until left meets right
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // If the mid element is less than the next one, peak must be in the right half
                left = mid + 1;
            } else {
                // Otherwise, the peak is in the left half
                right = mid;
            }
        }
        return left; // left and right converge to the index of a peak
    }
}
