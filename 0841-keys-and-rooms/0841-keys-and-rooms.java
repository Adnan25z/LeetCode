class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with room 0
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();

            // Process all keys in the current room
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);  // Add the unlocked room to the queue
                }
            }
        }

        // Check if all rooms were visited
        for (boolean wasVisited : visited) {
            if (!wasVisited) {
                return false;
            }
        }

        return true;
    }
}