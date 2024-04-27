import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), k, n, 1);
        return results;
    }
    
    private void backtrack(List<List<Integer>> results, List<Integer> combination, int k, int n, int start) {
        if (n == 0 && combination.size() == k) {
            results.add(new ArrayList<>(combination));
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (n - i < 0) break; // If current number is greater than remaining sum needed, break loop.
            if (combination.size() == k) break; // If already k numbers are used, break loop.
            
            combination.add(i); // Choose the number
            backtrack(results, combination, k, n - i, i + 1); // Explore further with this number included
            combination.remove(combination.size() - 1); // Backtrack, remove the number and try next one
        }
    }
}
