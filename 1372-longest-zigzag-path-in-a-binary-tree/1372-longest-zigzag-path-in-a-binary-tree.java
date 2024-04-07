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
    int maxLength = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    
    // Returns an array where result[0] is the length of the longest ZigZag path
    // starting and going left from this node, and result[1] is the same but going right.
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-1, -1};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // The length of the ZigZag path if we go left next is 1 + the length of the ZigZag
        // path going right from the left child. Similarly, if we go right next, it's 1 +
        // the length of the ZigZag path going left from the right child.
        int[] result = new int[]{1 + left[1], 1 + right[0]};
        
        // Update the global maximum ZigZag path length.
        maxLength = Math.max(maxLength, Math.max(result[0], result[1]));
        
        return result;
    }
}