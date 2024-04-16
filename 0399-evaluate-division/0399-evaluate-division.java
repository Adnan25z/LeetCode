class Solution {
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);
            double quotient = values[i];
            
            graph.putIfAbsent(numerator, new HashMap<>());
            graph.putIfAbsent(denominator, new HashMap<>());
            
            graph.get(numerator).put(denominator, quotient);
            graph.get(denominator).put(numerator, 1.0 / quotient);
        }

        double[] results = new double[queries.size()];
        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0; // One of the variables is not in the graph
            } else if (start.equals(end)) {
                results[i] = 1.0; // Dividing same variable by itself
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, visited, 1.0);
            }
        }
        return results;
    }

    private double dfs(String current, String target, Set<String> visited, double accProduct) {
        // Mark the current node as visited
        visited.add(current);
        
        Map<String, Double> neighbors = graph.get(current);
        if (neighbors.containsKey(target)) {
            return accProduct * neighbors.get(target);
        }

        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double result = dfs(next, target, visited, accProduct * entry.getValue());
                if (result != -1.0) {
                    return result;
                }
            }
        }

        // Backtrack
        visited.remove(current);
        return -1.0;
    }
}
