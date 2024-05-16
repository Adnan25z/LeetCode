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
    public boolean evaluateTree(TreeNode root) {
        // Base case: If the node is a leaf (0 or 1)
        if (root.left == null && root.right == null) {
            return root.val == 1; // Return true for 1, false for 0
        }
        
        // Recursive case: Calculate the values for the left and right subtrees
        boolean leftVal = evaluateTree(root.left);
        boolean rightVal = evaluateTree(root.right);
        
        // Apply the operation based on the value of the current node
        if (root.val == 2) { // OR operation
            return leftVal || rightVal;
        } else { // AND operation
            return leftVal && rightVal;
        }
    }
}
