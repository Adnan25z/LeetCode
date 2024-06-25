class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        // Create a map with the word count of the words array
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Traverse the string with a sliding window of size totalLength
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String substring = s.substring(i, i + totalLength);
            if (isValidSubstring(substring, wordLength, wordCount, wordMap)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isValidSubstring(String substring, int wordLength, int wordCount, Map<String, Integer> wordMap) {
        Map<String, Integer> currentMap = new HashMap<>();

        // Split the substring into words and count their occurrences
        for (int j = 0; j < wordCount; j++) {
            int wordStart = j * wordLength;
            String word = substring.substring(wordStart, wordStart + wordLength);
            currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
        }

        // Compare the word count maps
        return currentMap.equals(wordMap);
    }
}