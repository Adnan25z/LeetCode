class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the input array
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));  // Add the current subset to the result
        
        // Step 2: Iterate through the array and build subsets
        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: only process the first instance of a duplicate number in this step
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            // Step 3: Include the current number and move forward
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);  // Move to the next element
            tempList.remove(tempList.size() - 1);  // Backtrack: remove the last added element
        }
    }
}
