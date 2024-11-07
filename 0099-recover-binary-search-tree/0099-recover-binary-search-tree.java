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
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null, prev = null, temp = null;

        while (root != null) {
            if (root.left != null) {
                // Find the rightmost node in the left subtree or thread back to the root
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                
                // Create a thread to the root
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    // Revert the changes made in the tree structure
                    temp.right = null;
                    // Check for the swapped nodes
                    if (prev != null && prev.val > root.val) {
                        if (first == null) first = prev;
                        second = root;
                    }
                    prev = root;
                    root = root.right;
                }
            } else {
                // Check for the swapped nodes
                if (prev != null && prev.val > root.val) {
                    if (first == null) first = prev;
                    second = root;
                }
                prev = root;
                root = root.right;
            }
        }
        
        // Swap the values of the first and second nodes
        int tempVal = first.val;
        first.val = second.val;
        second.val = tempVal;
    }
}
