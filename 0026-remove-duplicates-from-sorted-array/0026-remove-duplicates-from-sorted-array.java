class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0; // Initialize the slow-pointer
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // Move the slow-pointer
                nums[i] = nums[j]; // Update the element at the slow-pointer
            }
        }
        return i + 1; // Return the count of unique elements
    }
}
