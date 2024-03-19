class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Fill answer array with left products
        answer[0] = 1; // No element to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Calculate right products on the fly and update answer array
        int rightProduct = 1; // Starts as 1 for the element at the rightmost side
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct; // Multiply by the right product so far
            rightProduct *= nums[i]; // Update the right product
        }
        
        return answer;
    }
}