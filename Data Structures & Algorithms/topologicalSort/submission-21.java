class Solution {
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
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++){
            if (!dfs(i, visiting, visited, sorted)){
               return Collections.emptyList(); 
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }
    
    boolean dfs(int src, Set<Integer> visiting,
        Set<Integer> visited, List<Integer> sorted){
        if (visited.contains(src)){
            return true;
        }        
        if (visiting.contains(src)){
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor, visiting, visited, sorted)){
                return false;
            }
        }
        visiting.remove(src);
        sorted.add(src);
        visited.add(src);
        return true;
    }
}

