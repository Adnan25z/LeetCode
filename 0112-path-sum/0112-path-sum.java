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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // Base case: empty tree

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, targetSum));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int sum = current.getValue();

            // Check if it's a leaf node
            if (node.left == null && node.right == null && sum == node.val) {
                return true;
            }

            // Push child nodes onto the stack with updated targetSum
            if (node.right != null) {
                stack.push(new Pair<>(node.right, sum - node.val));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, sum - node.val));
            }
        }

        return false; // No valid path found
    }
}
