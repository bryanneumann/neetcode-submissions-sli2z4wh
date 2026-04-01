class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
        }
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (!dfs(adj, visiting, visited, sorted, i)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, Set<Integer> visiting,
        Set<Integer> visited, List<Integer> sorted, int src){
        if (visiting.contains(src)){
            return false;
        }
        if (visited.contains(src)){
            return true;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
           if (!dfs(adj, visiting, visited, sorted, neighbor)){
            return false; 
           }
        }
        sorted.add(src);
        visited.add(src);
        visiting.remove(src);
        return true;
    }
}
