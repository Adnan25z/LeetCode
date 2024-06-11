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
   public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode convertToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Choose the middle element to make the root node
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        // Recursively build the left subtree
        node.left = convertToBST(nums, left, mid - 1);

        // Recursively build the right subtree
        node.right = convertToBST(nums, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode root1 = sortedArrayToBST(nums1);
        printTree(root1);

        int[] nums2 = {1, 3};
        TreeNode root2 = sortedArrayToBST(nums2);
        printTree(root2);
    }

    // Helper method to print the tree (in-order traversal)
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }
}
