class Solution {
public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Edge case: if needle is empty, return 0
        if (needleLength == 0) {
            return 0;
        }

        // Loop through the haystack to find the needle
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring matches the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        // If needle is not found in haystack, return -1
        return -1;
    }
}