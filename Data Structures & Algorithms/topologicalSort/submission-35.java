class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
       Map<Integer, List<Integer>> adj = new HashMap<>();
       Set<Integer> visiting = new HashSet<>();
       Set<Integer> visited = new HashSet<>();
       List<Integer> sorted = new ArrayList<>(); 
       for (int i = 0; i < n; i++){
        adj.put(i, new ArrayList<>());
       }
       for (int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
       }
       for (int i = 0; i < n; i++){
        if (!dfs(i, adj, visiting, visited, sorted)){
            return new ArrayList<>();
        }
       }
       Collections.reverse(sorted);
       return sorted; 
    }
    boolean dfs(int src, Map<Integer, List<Integer>> adj, Set<Integer> visiting,
        Set<Integer> visited, List<Integer> sorted){
        if (visiting.contains(src)){
            return false;
        }
        if (visited.contains(src)){
            return true;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor, adj, visiting, visited, sorted)){
                return false;
            }
        }
        sorted.add(src);
        visited.add(src);
        visiting.remove(src);
        return true;
    }
}
