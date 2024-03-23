class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int sum =0;
        for(int num : nums){
            sum+= num;
        }
        for (int i = 0; i<nums.length; i++){
            if(sum - leftSum - nums[i] == leftSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}