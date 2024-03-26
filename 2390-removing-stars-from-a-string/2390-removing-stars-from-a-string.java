class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        // Directly work with characters from the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                // Remove the last character from result if it's not empty
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // Append the character to result if it's not a star
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}

/*
class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder(); // Treat this as a stack.
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // If we see a star, remove the last character from the result.
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // If it's not a star, add it to the result.
                result.append(c);
            }
        }
        
        return result.toString();
    }
}



class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>(); // Use a stack to manage characters.
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // If we encounter a star, pop the last character from the stack.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // If it's not a star, push the character onto the stack.
                stack.push(c);
            }
        }
        
        // Convert the stack back to a string.
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString(); // Reverse the result because the stack is LIFO.
    }
}
*/
