class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long required = (success + spell - 1) / spell; // Calculate the required minimum strength of potion
            int idx = lowerBound(potions, required); // Find the index of the smallest potion that is sufficient
            pairs[i] = potions.length - idx; // Count of successful pairs is the number of elements from idx to end
        }
        return pairs;
    }

    // Binary search to find the lowest index at which value is >= target
    private int lowerBound(int[] array, long target) {
        int low = 0, high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
