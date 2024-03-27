class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Collision logic
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (-asteroid > stack.peek()) {
                    // Current asteroid destroys the top and continues
                    stack.pop();
                    continue;
                } else if (-asteroid == stack.peek()) {
                    // Both asteroids destroy each other
                    stack.pop();
                }
                // If the top asteroid is larger or both destroy each other, stop checking
                asteroid = 0;
            }
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}
