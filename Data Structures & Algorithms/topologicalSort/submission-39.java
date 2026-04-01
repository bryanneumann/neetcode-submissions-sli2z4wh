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
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
        }
        for (int i = 0; i< n; i++){
            if (!dfs(adj, i, sorted, visiting, visited)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int src, List<Integer> sorted, Set<Integer> visiting, Set<Integer> visited){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false; // Cycle
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, sorted, visiting, visited)){
                return false;
            }
        }
        visiting.remove(src);
        visited.add(src);
        sorted.add(src);
        return true;
    }
}
