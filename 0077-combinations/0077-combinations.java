import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int n, int k, int start) {
        // Base case: if combination size equals k, add it to result
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // Explore each possible number from start to n
        for (int i = start; i <= n; i++) {
            // Add i to the current combination
            combination.add(i);

            // Recursively call backtrack with the next number
            backtrack(result, combination, n, k, i + 1);

            // Backtrack: remove the last element added
            combination.remove(combination.size() - 1);
        }
    }
}