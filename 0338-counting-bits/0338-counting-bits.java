class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);  // Right shift to divide by 2, and add 1 if it's odd
        }
        
        return ans;
    }
}
