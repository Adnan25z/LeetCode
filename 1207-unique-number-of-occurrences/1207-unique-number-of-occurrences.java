class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count the occurrences of each number
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Check for unique occurrences
        HashSet<Integer> occurrences = new HashSet<>();
        for (int count : countMap.values()) {
            if (!occurrences.add(count)) {
                // If the count was not added, it's because it was already in the set
                return false;
            }
        }
        
        // Step 3: If all occurrences are unique
        return true;
    }
}