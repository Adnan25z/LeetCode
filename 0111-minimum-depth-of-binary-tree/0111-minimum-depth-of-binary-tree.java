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
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // Base case: empty tree has depth 0
        
        // Recursively find the depth of left and right subtrees
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // If one of the subtrees is null, take the non-null subtree's depth
        if (root.left == null) return rightDepth + 1;
        if (root.right == null) return leftDepth + 1;
        
        // Return the minimum of the two depths
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
