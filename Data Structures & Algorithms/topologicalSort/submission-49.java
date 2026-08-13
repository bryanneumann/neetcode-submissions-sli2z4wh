class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!sort(i, adj, sorted, visiting, visited)) {
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean sort(int src, Map<Integer, List<Integer>> adj, List<Integer> sorted,
        Set<Integer> visiting, Set<Integer> visited) {
        if (visiting.contains(src)) {
            return false; // Cycle
        }
        if (visited.contains(src)) {
            return true; // Finished
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)) {
            if (!sort(neighbor, adj, sorted, visiting, visited)) {
                return false;
            }
        }
        sorted.add(src);
        visited.add(src);
        visiting.remove(src);
        return true;
    }
}
