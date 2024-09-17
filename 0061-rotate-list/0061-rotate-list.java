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
     public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find the length of the list
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Connect the tail to the head to form a circular list
        tail.next = head;
        
        // Step 3: Find the new tail (the node before the new head)
        // Effective rotations needed is k % length
        k = k % length;
        int stepsToNewHead = length - k;  // Find the new tail's position
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Break the circular list
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}