class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false; // Strings of different lengths cannot be close.
        
        HashMap<Character, Integer> freqMap1 = new HashMap<>();
        HashMap<Character, Integer> freqMap2 = new HashMap<>();
        
        // Populate frequency maps for both strings.
        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            freqMap1.put(c1, freqMap1.getOrDefault(c1, 0) + 1);
            freqMap2.put(c2, freqMap2.getOrDefault(c2, 0) + 1);
        }
        
        // Verify both strings have the same set of characters.
        if (!freqMap1.keySet().equals(freqMap2.keySet())) {
            return false;
        }
        
        // Sort the frequency values from both maps to ensure the same frequency distribution.
        ArrayList<Integer> freqList1 = new ArrayList<>(freqMap1.values());
        ArrayList<Integer> freqList2 = new ArrayList<>(freqMap2.values());
        Collections.sort(freqList1);
        Collections.sort(freqList2);
        
        // Directly compare the sorted lists of frequencies.
        return freqList1.equals(freqList2);
    }
}
