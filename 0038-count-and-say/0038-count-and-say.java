class Solution {
     public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }

        String current = "1"; // Base case
        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();
            int length = current.length();
            int count = 1;

            for (int j = 1; j < length; j++) {
                if (current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(current.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last group
            next.append(count).append(current.charAt(length - 1));
            current = next.toString();
        }

        return current;
    }
}