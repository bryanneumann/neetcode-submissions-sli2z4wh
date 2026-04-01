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
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(adj, sorted, visited, visiting, i )){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj,
        List<Integer> sorted, Set<Integer> visited, Set<Integer> visiting, int i){
        if (visiting.contains(i)){
            return false; // Cycle detected
        }
        if (visited.contains(i)){
            return true;
        }
        visiting.add(i);
        for (Integer neighbor : adj.get(i)){
            if (!dfs(adj, sorted, visited, visiting, neighbor)){
                return false;
            }
        }
        sorted.add(i);
        visited.add(i);
        visiting.remove(i);
        return true;
    }
}
