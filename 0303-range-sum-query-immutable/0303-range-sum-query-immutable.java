class NumArray {

    private int[] prefixSums;

    public NumArray(int[] nums) {
        prefixSums = new int[nums.length + 1];
        prefixSums[0] = 0;  // Initialize the first element to 0 for convenience

        // Build the prefix sum array
        for (int i = 1; i <= nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        // Calculate the sum using the prefix sum array
        return prefixSums[right + 1] - prefixSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */