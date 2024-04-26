class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        String[] mapping = new String[] {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        List<String> results = new ArrayList<>();
        backtrack(results, digits, mapping, new StringBuilder(), 0);
        return results;
    }
    
    private void backtrack(List<String> results, String digits, String[] mapping, StringBuilder current, int index) {
        if (index == digits.length()) {
            results.add(current.toString());
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(results, digits, mapping, current, index + 1);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}
