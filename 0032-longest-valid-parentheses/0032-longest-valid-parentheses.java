class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initial base case
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); // Push the index of '(' onto the stack
            } else {
                stack.pop(); // Pop the top of the stack for a matching ')'
                
                if (stack.isEmpty()) {
                    stack.push(i); // Push the current index as a base for the next valid substring
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}