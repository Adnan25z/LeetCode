class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
                List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) return quadruplets;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate with two outer loops to fix two numbers
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Use two pointers for the remaining pair
                int left = j + 1;
                int right = nums.length - 1;
                long newTarget = (long)target - (long)nums[i] - (long)nums[j];

                while (left < right) {
                    long currentSum = (long)nums[left] + (long)nums[right];
                    if (currentSum == newTarget) {
                        // Add the found quadruplet to the list
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        // Move the pointers after processing the pair
                        left++;
                        right--;
                    } else if (currentSum < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }
}