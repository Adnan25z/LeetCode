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
    public int pathSum(TreeNode root, int targetSum) {
        // Map to store the prefix sum and its frequency.
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // Initialize with sum 0 being 1 to handle the case when the path starts from the root.
        prefixSumCount.put(0L, 1);
        return dfs(root, 0, targetSum, prefixSumCount);
    }
    
    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }
        
        // Update the current sum.
        currentSum += node.val;
        // Calculate the number of valid paths that end at the current node.
        int numPathsToCurr = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        
        // Update the map with the current sum.
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        
        // Explore the children.
        int result = numPathsToCurr + dfs(node.left, currentSum, targetSum, prefixSumCount)
                                    + dfs(node.right, currentSum, targetSum, prefixSumCount);
        
        // After returning from recursion, remove the current sum from the map to avoid
        // affecting other paths.
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        
        return result;
    }
}