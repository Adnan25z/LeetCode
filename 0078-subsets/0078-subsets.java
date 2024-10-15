class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(subset));

        // Explore further subsets by including each element from start to end
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]); // Include nums[i]
            backtrack(result, subset, nums, i + 1); // Recursively explore further
            subset.remove(subset.size() - 1); // Backtrack to explore other possibilities
        }
    }
}
