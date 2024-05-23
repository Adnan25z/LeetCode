class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum =  nums[0] + nums[1] + nums[2]; // Initialize with the sum of the first three elements
        
        for(int i=0; i<n-2; i++) {
            int left = i+1;
            int right = n-1;
            
            while(left<right){
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Step 4: Update the closest sum if the current sum is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                // Step 5: Move pointers
                if (currentSum < target) {
                    left++;  // Move the left pointer to the right to increase the sum
                } else if (currentSum > target) {
                    right--;  // Move the right pointer to the left to decrease the sum
                } else {
                    // If the current sum is exactly equal to the target, return it
                    return currentSum;
                }
            }
        }
        return closestSum;
    }
}