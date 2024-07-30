class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; // Pointer to the position where the next unique element can be placed
        for (int j = 0; j < nums.length; j++) {
            // Condition to allow at most two occurrences of each element
            if (i < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // The length of the modified array
    }
}