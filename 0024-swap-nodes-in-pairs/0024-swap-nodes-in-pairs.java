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
   public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify the swapping process
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the list and swap pairs
        while (current.next != null && current.next.next != null) {
            // Identify the nodes to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swap the nodes
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        // Return the new head of the list
        return dummy.next;
    }
}