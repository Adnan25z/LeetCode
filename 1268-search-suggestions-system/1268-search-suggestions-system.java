import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // Sort products to ensure lexicographical order
        TrieNode root = new TrieNode();

        // Build the Trie
        for (String product : products) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                if (node.suggestions.size() < 3) { // Store only up to 3 suggestions per node
                    node.suggestions.add(product);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        // Search for each prefix of the searchWord
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            if (node == null) {
                result.add(new ArrayList<>());
            } else {
                result.add(node.suggestions);
            }
        }
        return result;
    }
}
