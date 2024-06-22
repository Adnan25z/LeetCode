class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the element exists in the map and if the index difference is within the range k
            if (map.containsKey(nums[i])) {
                int previousIndex = map.get(nums[i]);
                if (i - previousIndex <= k) {
                    return true;
                }
            }
            // Update the map with the current index of the element
            map.put(nums[i], i);
        }
        
        // No such pair found
        return false;
    }
}