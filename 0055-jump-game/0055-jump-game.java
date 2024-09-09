class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If i exceeds the farthest reachable index, return false
            if (i > farthest) {
                return false;
            }
            
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + nums[i]);
            
            // If farthest reaches or exceeds the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}