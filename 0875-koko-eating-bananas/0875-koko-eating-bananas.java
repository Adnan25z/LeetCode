class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        // Finding the maximum pile to set as the initial maximum speed
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid; // Try a smaller speed
            } else {
                left = mid + 1; // Increase the speed
            }
        }
        return left; // Left and right converge to the smallest possible k
    }
    
    // Helper function to determine if Koko can finish with the given speed in h hours
    private boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + k - 1) / k; // Ceil of pile/k
            if (hoursNeeded > h) return false; // If hours exceed h, not possible
        }
        return true;
    }
}
