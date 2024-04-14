class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++; // Each DFS call that starts from here indicates a new province.
            }
        }
        
        return count;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int currentCity) {
        visited[currentCity] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[currentCity][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
}
