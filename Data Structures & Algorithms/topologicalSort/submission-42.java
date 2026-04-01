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
        for (int i = 0; i < n; i++){
          if (!dfs(adj, sorted, visited, visiting, i)){
            return new ArrayList<>();
          }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, List<Integer> sorted,
        Set<Integer> visited, Set<Integer> visiting, int src){
      if (visited.contains(src)){
        return true;
      }

      if (visiting.contains(src)){ // Cycle
        return false;
      }
      visiting.add(src);
      for (int neighbor : adj.get(src)){
        if (!dfs(adj, sorted, visited, visiting, neighbor)){
          return false;
        }
      }
      visiting.remove(src);
      visited.add(src);
      sorted.add(src);
      return true;
    } 
}
