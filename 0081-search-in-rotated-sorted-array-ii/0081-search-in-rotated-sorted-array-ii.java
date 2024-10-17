class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we find the target, return true
            if (nums[mid] == target) {
                return true;
            }

            // If duplicates are at the boundary, increment left and decrement right
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            // Left part is sorted
            else if (nums[left] <= nums[mid]) {
                // Check if target is in the left sorted portion
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right part is sorted
            else {
                // Check if target is in the right sorted portion
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // If we finish the loop without finding the target, return false
        return false;
    }
}
