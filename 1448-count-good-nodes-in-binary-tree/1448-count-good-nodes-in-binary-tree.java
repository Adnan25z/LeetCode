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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        // Update the count of good nodes.
        int count = node.val >= maxSoFar ? 1 : 0;
        
        // Update the maxSoFar for the path to the current node.
        maxSoFar = Math.max(maxSoFar, node.val);
        
        // Continue DFS traversal for left and right children.
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        
        return count;
    }
}