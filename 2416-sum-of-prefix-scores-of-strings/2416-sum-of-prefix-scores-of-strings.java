import java.util.*;

class Solution {
    // Define the Trie node structure
    class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            this.children = new TrieNode[26];  // For each lowercase English letter
            this.count = 0;
        }
    }

    // Root node of the Trie
    private TrieNode root = new TrieNode();

    // Insert a word into the Trie and update prefix counts
    private void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.count++;  // Update prefix count
        }
    }

    // Get the sum of prefix scores for a given word
    private int getPrefixScore(String word) {
        TrieNode current = root;
        int sum = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) break;  // No further prefixes
            current = current.children[index];
            sum += current.count;  // Add the count of this prefix
        }
        return sum;
    }

    public int[] sumPrefixScores(String[] words) {
        // First, insert all words into the Trie
        for (String word : words) {
            insert(word);
        }

        // Now, calculate the sum of prefix scores for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = getPrefixScore(words[i]);
        }

        return result;
    }
}
