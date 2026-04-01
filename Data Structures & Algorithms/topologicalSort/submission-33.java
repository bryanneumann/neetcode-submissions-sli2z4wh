class Solution {
    List<Integer> sorted = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    Map<Integer, List<Integer>> adj = new HashMap<>(); 
    public List<Integer> topologicalSort(int n, int[][] edges) {
       for (int i = 0; i < n; i++){
        adj.put(i, new ArrayList<>());
       } 
       for (int[] edge : edges){
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
       }

       for (int i = 0; i < n; i++){
            if (!dfs(i)){
                return sorted;
            }
       }
       Collections.reverse(sorted);
       return sorted;
    }

    boolean dfs(int src){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
           if (!dfs(neighbor)) {
            return false;
           }
        }
        visited.add(src);
        sorted.add(src);
        visiting.remove(visiting.size() - 1);
        return true;
    }
}
