class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> sorted = new ArrayList<>();

        for (int i =0; i < n; i++){
            if (!dfs(adj, i, visited, visiting, sorted)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int src, Set<Integer> visited, Set<Integer> visiting, List<Integer> sorted){
        if (visited.contains(src)){
            return true; // no cycle
        }
        if (visiting.contains(src)){
            // Cycle
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, visited, visiting, sorted)){
                return false; // Cycle
            }
        }
        visiting.remove(src);
        visited.add(src);
        sorted.add(src);
        return true; // No cycle
    }
}
