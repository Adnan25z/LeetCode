class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // Base case: when the current string is of length 2 * n
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // If we can add an opening parenthesis
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // If we can add a closing parenthesis
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}