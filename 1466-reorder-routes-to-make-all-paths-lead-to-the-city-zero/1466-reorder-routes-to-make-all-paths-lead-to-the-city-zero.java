class Solution {
    public int minReorder(int n, int[][] connections) {
        // Graph to store both forward and backward connections
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        // Populate the graph
        for (int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];
            
            // Marking forward direction with a 'need to reverse' flag (1)
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            // Marking backward direction with 'no need to reverse' flag (0)
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }
        
        // Visited array to keep track of visited cities
        boolean[] visited = new boolean[n];
        
        // Starting DFS from city 0
        return dfs(graph, 0, visited);
    }
    
    private int dfs(Map<Integer, List<int[]>> graph, int current, boolean[] visited) {
        visited[current] = true;
        int changeCount = 0;
        
        if (graph.containsKey(current)) {
            for (int[] adj : graph.get(current)) {
                int nextCity = adj[0];
                int needsReverse = adj[1];
                
                if (!visited[nextCity]) {
                    // Add to count if we are using a forward direction that needs reverse
                    changeCount += needsReverse;
                    // Continue DFS to next city
                    changeCount += dfs(graph, nextCity, visited);
                }
            }
        }
        
        return changeCount;
    }
}
