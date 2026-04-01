class Solution {
    int n;
    public List<Integer> topologicalSort(int n, int[][] edges) {
       this.n = n; 
       List<Integer> sorted = new ArrayList<>();
       Set<Integer> visited = new HashSet<>();
       List<Integer> visiting = new ArrayList<>();
       Map<Integer, List<Integer>> adj = new HashMap<>();
       for (int i = 0; i < n; i++){
         adj.put(i, new ArrayList<>());
       }
       for (int[] edge : edges){
         adj.get(edge[0]).add(edge[1]);
       }
       for (int i = 0; i < n; i++){
         if (!dfs(adj, i, visited, visiting, sorted)){
            return new ArrayList<>();
         }
       }
       Collections.reverse(sorted);
       return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int src, Set<Integer> visited, List<Integer> visiting, List<Integer> sorted){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src) || src == n){
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, visited, visiting, sorted)){
                return false;
            }
        }
        visited.add(src);
        sorted.add(src);
        visiting.removeLast();
        return true;
    }
}
