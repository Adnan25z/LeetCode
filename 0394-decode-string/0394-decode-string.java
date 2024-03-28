class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String currentString = "";
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Accumulate the digit for the number k
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current count and string to their respective stacks
                counts.push(k);
                resultStack.push(currentString);
                // Reset for the new segment
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                // Pop count and string to construct the repeated segment
                StringBuilder temp = new StringBuilder(resultStack.pop());
                int repeatTimes = counts.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(currentString);
                }
                currentString = temp.toString();
            } else {
                // Add current character to the string
                currentString += ch;
            }
        }
        
        return currentString;
    }
}
