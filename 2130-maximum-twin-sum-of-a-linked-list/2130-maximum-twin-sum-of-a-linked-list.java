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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<>();
        
        // Find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Push values from the middle to the end into the stack
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        
        int maxTwinSum = 0;
        // Calculate twin sums for the first half and their twins from the stack
        while (!stack.isEmpty()) {
            int currentTwinSum = head.val + stack.pop();
            maxTwinSum = Math.max(maxTwinSum, currentTwinSum);
            head = head.next;
        }
        
        return maxTwinSum;
    }
}