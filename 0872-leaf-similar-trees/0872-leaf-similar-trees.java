/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // DFS to collect leaf values for both trees
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        
        // Check if the leaf sequences are identical
        return leaves1.equals(leaves2);
    }
    
    private void dfs(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        
        // If it's a leaf node, add its value to the list
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        
        // Continue DFS traversal
        dfs(node.left, leaves);
        dfs(node.right, leaves);
    }
}