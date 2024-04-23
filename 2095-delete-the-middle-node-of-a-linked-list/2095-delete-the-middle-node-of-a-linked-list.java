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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // Edge case for 1 node or empty list
        }
        
        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        
        // Move fast pointer at 2x speed and slow at 1x speed
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Slow is now just before the middle node
        slow.next = slow.next.next; // Delete the middle node
        
        return dummy.next; // Return the modified list
    }
}
