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
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: if the current node is null, return null.
        if (root == null) {
            return null;
        }
        
        // If we find the node with the value equal to `val`, return the node.
        if (root.val == val) {
            return root;
        }
        
        // If `val` is less than the current node's value, search in the left subtree.
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        // If `val` is greater than the current node's value, search in the right subtree.
        else {
            return searchBST(root.right, val);
        }
    }
}