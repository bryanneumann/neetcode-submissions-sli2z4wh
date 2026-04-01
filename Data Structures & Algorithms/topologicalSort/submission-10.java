class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
        }
        for (int i = 0; i < n; i++){
            dfs(adj, i, visiting, visited, sorted);
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj,
        int src, Set<Integer> visiting, Set<Integer> visited, List<Integer> sorted){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false; // Cycle
        }
        visiting.add(src);
        for (Integer neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, visiting, visited, sorted)){
                return false; // Cycle
            }
        }
        visiting.remove(src);
        visited.add(src);
        sorted.add(src);
        return true;
    }
    
}
