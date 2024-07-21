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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Count the number of nodes in the list
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        // Initialize pointers
        ListNode prevGroupEnd = dummy;
        ListNode groupStart = head;

        // Process each group
        while (count >= k) {
            ListNode prev = null;
            ListNode current = groupStart;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }

            // Connect the reversed group with the previous and next segments
            prevGroupEnd.next = prev;
            groupStart.next = current;

            // Move the pointers for the next group
            prevGroupEnd = groupStart;
            groupStart = current;

            // Reduce the count by k
            count -= k;
        }

        return dummy.next;
    }
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}