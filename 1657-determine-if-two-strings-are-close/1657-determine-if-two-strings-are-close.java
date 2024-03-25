class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false; // Early return if lengths differ
        
        // Count the frequency of each character in both words
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        
        // Ensure both strings have the same set of characters
        if (!freq1.keySet().equals(freq2.keySet())) return false;
        
        // Convert frequency values to lists and sort them
        List<Integer> values1 = new ArrayList<>(freq1.values());
        List<Integer> values2 = new ArrayList<>(freq2.values());
        Collections.sort(values1);
        Collections.sort(values2);
        
        // The sorted lists of frequencies must match
        return values1.equals(values2);
    }
}
