import java.util.HashMap;

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int operations = 0;

        // Count the occurrences of each number
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            int complement = k - num;
            if (counts.getOrDefault(num, 0) > 0 && counts.getOrDefault(complement, 0) > 0) {
                // If num and complement are the same, ensure at least 2 instances exist
                if (num == complement && counts.get(num) < 2) {
                    continue;
                }
                // Perform the operation and decrement the counts
                counts.put(num, counts.get(num) - 1);
                counts.put(complement, counts.get(complement) - 1);
                operations++;
            }
        }

        return operations;
    }
}