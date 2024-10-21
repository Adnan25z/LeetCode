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
    public ListNode partition(ListNode head, int x) {
        // Dummy heads for the two partitions
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        
        // Pointers for building the two lists
        ListNode less = lessHead;
        ListNode greater = greaterHead;
        
        // Traverse the original list
        while (head != null) {
            if (head.val < x) {
                // Add to the 'less' list
                less.next = head;
                less = less.next;
            } else {
                // Add to the 'greater or equal' list
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        
        // Combine the two lists
        greater.next = null;  // Important to avoid cycle
        less.next = greaterHead.next;  // Append greater list after less list
        
        // Return the head of the combined list
        return lessHead.next;
    }
}