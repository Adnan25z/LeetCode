/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null; // Base case: empty list
        if (head.next == null) return new TreeNode(head.val); // Single node
        
        // Step 1: Find the middle node
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half
        if (prev != null) prev.next = null;

        // Step 2: Create the root node
        TreeNode root = new TreeNode(slow.val);

        // Step 3: Recursively build the left and right subtrees
        root.left = sortedListToBST(head); // Left subtree from the left half
        root.right = sortedListToBST(slow.next); // Right subtree from the right half

        return root;
    }
}