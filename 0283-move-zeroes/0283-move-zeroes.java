class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0; // This is where you stand, ready to place the next toy.
        
        // Step through the line of boxes, starting from the left.
        for (int num : nums) {
            if (num != 0) { // If you find a toy...
                nums[insertPos++] = num; // ...move it to your current position, and step forward.
            }
        }
        
        // Once you've moved all the toys up the line...
        while (insertPos < nums.length) {
            nums[insertPos++] = 0; // ...fill the rest of the line with empty boxes.
        }
    }
}
