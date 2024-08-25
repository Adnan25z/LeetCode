class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int jumps = 0;         // Number of jumps made
        int currentEnd = 0;    // End of the current jump
        int farthest = 0;      // The farthest index we can reach

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current jump, we need to make another jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we have reached or exceeded the last index, break out of the loop
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}