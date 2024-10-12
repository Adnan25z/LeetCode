class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        // Dictionary which keeps a count of all the unique characters in t.
        HashMap<Character, Integer> dict_t = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dict_t.put(c, dict_t.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters in t that need to be present in the window
        int required = dict_t.size();

        // Left and Right pointers
        int left = 0, right = 0;

        // Formed is used to track how many unique characters in t are present
        // in the current window in the desired frequency.
        int formed = 0;

        // Dictionary to keep track of characters in the current window
        HashMap<Character, Integer> window_counts = new HashMap<>();

        // (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            window_counts.put(c, window_counts.getOrDefault(c, 0) + 1);

            // If the frequency of the current character added matches the desired count in t
            if (dict_t.containsKey(c) && window_counts.get(c).intValue() == dict_t.get(c).intValue()) {
                formed++;
            }

            // Try to contract the window till it becomes invalid
            while (left <= right && formed == required) {
                c = s.charAt(left);
                // Save the smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the left pointer is no longer a part of the window
                window_counts.put(c, window_counts.get(c) - 1);
                if (dict_t.containsKey(c) && window_counts.get(c).intValue() < dict_t.get(c).intValue()) {
                    formed--;
                }

                // Move the left pointer to contract the window
                left++;
            }

            // Keep expanding the window
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
