class Solution {
    public int longestSubarray(int[] nums) {
        int left=0, right=0, zCount=0, maxLength=0;
        while(right<nums.length){
            if(nums[right] == 0){
                zCount++;
            }
            while(zCount>1){
                if(nums[left] == 0){
                    zCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left);
            right++;
        }
        if(maxLength == nums.length -1 && zCount == 0){
            return maxLength;
        }
        return maxLength;
    }
}