class Solution {
    public String decodeString(String s) {
        Stack<Integer> multiplierStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int currentNumber = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push current state to stacks and reset
                multiplierStack.push(currentNumber);
                stringStack.push(currentString);
                currentNumber = 0;
                currentString = "";
            } else if (ch == ']') {
                // Pop and decode
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int multiplier = multiplierStack.pop();
                for (int i = 0; i < multiplier; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else { // Character is a letter
                currentString += ch;
            }
        }
        
        return currentString;
    }
}
