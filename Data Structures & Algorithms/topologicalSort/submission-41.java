class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
       Map<Integer, List<Integer>>  adj = new HashMap<>();
       Set<Integer> visited = new HashSet<>();
       List<Integer> sorted = new ArrayList<>();
       List<Integer> visiting = new ArrayList<>();
       for (int i = 0; i < n; i++){
        adj.put(i, new ArrayList<>());
       }
       for (int[] edge : edges){
        int s = edge[0];
        int d = edge[1];
        adj.get(s).add(d);
       }
       for (int i = 0; i < n; i++){
        if (!dfs(adj, visited, sorted, visiting, i)){
          return new ArrayList<>();
        }
       }
       Collections.reverse(sorted);
       return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, List<Integer> sorted, List<Integer> visiting, int src){
      if (visited.contains(src)){
        return true;
      }
      // If cycle
      if (visiting.contains(src)){
        return false;
      }
      visiting.add(src);
      for (int neighbor : adj.getOrDefault(src, new ArrayList<>())){ 
        if (!dfs(adj, visited, sorted, visiting, neighbor)){
          return false;
        }
      }
      visited.add(src);
      sorted.add(src);
      visiting.removeLast();
      return true;
    }
}
