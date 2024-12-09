/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node current = root; // Start with the root node

        while (current != null) {
            Node dummy = new Node(0); // Dummy node for the next level
            Node tail = dummy;       // Tail pointer to connect nodes in the next level

            // Traverse the current level
            while (current != null) {
                if (current.left != null) {
                    tail.next = current.left;
                    tail = tail.next;
                }
                if (current.right != null) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                // Move to the next node in the current level
                current = current.next;
            }

            // Move to the next level
            current = dummy.next;
        }

        return root;
    }
}
