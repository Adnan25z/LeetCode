class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            // If the list is empty or has only one element, return it as is.
            return head;
        }

        ListNode odd = head; // Start with the first node for the odd-indexed list.
        ListNode evenHead = head.next; // Keep the head of the even-indexed list.
        ListNode even = evenHead; // Start with the second node for the even-indexed list.
        
        // Traverse the list to separate odd and even nodes.
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next; // Move odd pointer to the next odd node.
            even.next = odd.next;
            even = even.next; // Move even pointer to the next even node.
        }

        // Connect the last node of the odd list to the head of the even list.
        odd.next = evenHead;
        
        // Return the modified list head.
        return head;
    }
}
