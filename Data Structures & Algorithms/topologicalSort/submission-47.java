class Solution {
    private List<Integer> sorted = new ArrayList<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public List<Integer> topologicalSort(int n, int[][] edges) {
        // Build adjacency map for dfs
        for (int i =0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(i, n)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(int v, int n){
        if (visiting.contains(v)){
            // Cycle found.
            return false;

        }
        if (visited.contains(v)){
            // Already done with this vertex.
            return true;
        }
        visiting.add(v);
        for (int neighbor : adj.get(v)){
            if (!dfs(neighbor, n)){
                return false;
            }
        }
        visited.add(v);
        visiting.remove(v);
        sorted.add(v);
        return true;
    }
}
