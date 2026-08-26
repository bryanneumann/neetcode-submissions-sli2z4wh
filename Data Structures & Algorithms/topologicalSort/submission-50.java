class Solution {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    List<Integer> sorted = new ArrayList<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    public List<Integer> topologicalSort(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) {
                return new ArrayList<>();
            }
        }
        // Topsort sorts descending by default, so reverse the list
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(int src) {
        if (visiting.contains(src)) {
            // Cycle
            return false;
        }
        if (visited.contains(src)) {
            // Done
            return true;
        }
        visiting.add(src);
        for (int neighbor : adj.getOrDefault(src, new ArrayList<>())) {
            if (!dfs(neighbor)) {
                return false;
            }
        }
        visited.add(src);
        visiting.remove(src);
        sorted.add(src);
        return true;
    }
}
