class Solution {
    public static int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];  // Array to count frequency of each number (0 to 100)
        int pairs = 0;
        int leftovers = 0;

        // Count the frequency of each number in the input array
        for (int num : nums) {
            freq[num]++;
        }

        // Calculate the number of pairs and leftovers
        for (int count : freq) {
            pairs += count / 2;       // Each pair is formed by two of the same number
            leftovers += count % 2;   // Leftovers are the numbers that don't form a pair
        }

        return new int[]{pairs, leftovers};
    }
}