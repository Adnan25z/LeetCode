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
    private int maxPathSumResult;

    public int maxPathSum(TreeNode root) {
        maxPathSumResult = Integer.MIN_VALUE; // Initialize the maximum path sum
        calculatePathSum(root); // Start DFS from the root
        return maxPathSumResult;
    }

    private int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the max path sum of the left and right subtrees
        int leftSum = Math.max(0, calculatePathSum(node.left));  // Ignore negative sums
        int rightSum = Math.max(0, calculatePathSum(node.right));

        // Calculate the maximum path sum including the current node as the "root" of the path
        int currentPathSum = leftSum + rightSum + node.val;

        // Update the global maximum path sum result
        maxPathSumResult = Math.max(maxPathSumResult, currentPathSum);

        // Return the maximum sum path that includes the current node and one of its subtrees
        return node.val + Math.max(leftSum, rightSum);
    }
}
