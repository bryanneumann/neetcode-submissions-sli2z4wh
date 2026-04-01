class Solution {
    /**
     Top sort with cycle detection
    */
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
        }
        for (int i = n - 1; i >= 0; i--){
            if (!dfs(i, visited, visiting, sorted, adj)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(int src, Set<Integer> visited,
        Set<Integer> visiting, List<Integer> sorted,
        Map<Integer, List<Integer>> adj){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor, visited, visiting, sorted, adj)) {
                return false;
            }
        }
        visiting.remove(src);
        visited.add(src);
        sorted.add(src);
        return true; // No cycle
    }
}
