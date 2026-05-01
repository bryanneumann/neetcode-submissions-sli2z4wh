class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];
            adj.get(src).add(dst);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(i, sorted, visited, visiting, adj)){
                return new ArrayList<>();
            }
        }
        // The list is sorted in reverse of natural order, so
        // reverse to get to natural ordering.
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(int src, List<Integer> sorted, Set<Integer> visited,
        Set<Integer> visiting, Map<Integer, List<Integer>> adj){
        if (visiting.contains(src)){
            // Cycle found, get out of here.
            return false;
        }
        if (visited.contains(src)){
            // Already visited, so we can stop.
            return true;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor, sorted, visited, visiting, adj)){
                return false;
            }
        }
        visiting.remove(src);
        visited.add(src);
        sorted.add(src);
        return true;
    }
}
