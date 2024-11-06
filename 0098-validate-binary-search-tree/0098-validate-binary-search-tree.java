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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValid(TreeNode node, long min, long max) {
        // An empty tree is a valid BST
        if (node == null) return true;
        
        // Check the current node's value
        if (node.val <= min || node.val >= max) return false;
        
        // Recursively check left and right subtrees with updated ranges
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
