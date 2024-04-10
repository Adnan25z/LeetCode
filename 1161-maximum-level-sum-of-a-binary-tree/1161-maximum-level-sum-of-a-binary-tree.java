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
    public int maxLevelSum(TreeNode root) {
        // Check if the tree is empty
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        
        while (!queue.isEmpty()) {
            int levelLength = queue.size(); // Number of nodes at the current level
            int currentSum = 0;
            level++; // Increment level number for each new level
            
            for (int i = 0; i < levelLength; i++) {
                TreeNode currentNode = queue.poll();
                currentSum += currentNode.val;
                
                // Enqueue left and right children of the current node
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            
            // Update maximum level sum and level number if current level's sum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLevel = level;
            }
        }
        
        return maxLevel;
    }
}