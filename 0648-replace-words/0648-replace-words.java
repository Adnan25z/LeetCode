import java.util.*;

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }
    
    private void buildTrie(TrieNode root, List<String> roots) {
        for (String rootWord : roots) {
            TrieNode node = root;
            for (char ch : rootWord.toCharArray()) {
                node = node.children.computeIfAbsent(ch, k -> new TrieNode());
            }
            node.word = rootWord;  // Mark the end of a root word
        }
    }
    
    private String findRoot(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
                if (node.word != null) {
                    return node.word;
                }
            } else {
                break;
            }
        }
        return word;  // Return original word if no root found
    }
    
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        buildTrie(root, dictionary);
        
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");
        
        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            result.append(findRoot(root, words[i]));
        }
        
        return result.toString();
    }
}
