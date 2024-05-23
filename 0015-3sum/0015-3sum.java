class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // Step 1: Sort the array
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n - 2; i++) {
            // Step 4: Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2 and 3: Two-pointer technique
            int left = i + 1, right = n - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    // Step 4: Avoid duplicates for the second and third elements
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (total < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }
}