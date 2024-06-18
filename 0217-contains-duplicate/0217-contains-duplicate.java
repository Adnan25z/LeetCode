class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueElements = new HashSet<>();

        // Iterate through each element in the array
        for (int num : nums) {
            // Attempt to add the element to the HashSet
            // If add returns false, the element is a duplicate
            if (!uniqueElements.add(num)) {
                return true;  // Duplicate found
            }
        }

        // No duplicates found
        return false;
    }
}