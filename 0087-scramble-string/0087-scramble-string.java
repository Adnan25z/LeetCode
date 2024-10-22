class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        // Base case: if both strings are equal, they are scrambled strings
        if (s1.equals(s2)) {
            return true;
        }
        
        // If lengths are not the same, they cannot be scrambled versions of each other
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check the memoization table
        String key = s1 + "," + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // If the sorted versions of the strings are not equal, they cannot be scrambled strings
        if (!sameCharacters(s1, s2)) {
            memo.put(key, false);
            return false;
        }
        
        int n = s1.length();
        
        // Try all possible split positions
        for (int i = 1; i < n; i++) {
            // Non-swapped case: s1[0:i] matches s2[0:i] and s1[i:] matches s2[i:]
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Swapped case: s1[0:i] matches s2[n-i:] and s1[i:] matches s2[0:n-i]
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }
        
        // If no valid scramble found, return false
        memo.put(key, false);
        return false;
    }
    
    // Helper function to check if two strings have the same characters (anagram check)
    private boolean sameCharacters(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
