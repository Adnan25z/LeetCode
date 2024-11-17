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
    private HashMap<Integer, Integer> inorderMap;
    private int postorderIndex;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postorderIndex = postorder.length - 1; // Start from the end of the postorder list
        
        // Map each value to its index in the inorder traversal for quick access
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        
        // The current root node value from postorder traversal
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);
        
        // Split the inorder list into left and right subtrees
        int rootIndexInInorder = inorderMap.get(rootVal);
        
        // Build right subtree first (postorder traversal processes right subtree before left subtree)
        root.right = buildTreeHelper(postorder, rootIndexInInorder + 1, inEnd);
        root.left = buildTreeHelper(postorder, inStart, rootIndexInInorder - 1);
        
        return root;
    }
}
