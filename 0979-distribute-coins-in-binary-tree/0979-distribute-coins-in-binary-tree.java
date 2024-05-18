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
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        
        int leftCoins = dfs(node.left);   // Coins needed/extra in left subtree
        int rightCoins = dfs(node.right); // Coins needed/extra in right subtree
        
        moves += Math.abs(leftCoins) + Math.abs(rightCoins); // Moves needed to balance this subtree
        
        return node.val + leftCoins + rightCoins - 1; // Total coins in subtree minus one (the coin that should remain at the node)
    }
}
