class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i =  0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(adj, i, sorted, visited, visiting)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);

        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int src, List<Integer> sorted, Set<Integer> visited,
        Set<Integer> visiting){
        if (visiting.contains(src)){
            // Cycle found
            return false;
        }
        if (visited.contains(src)){
            return true;
        }
        visiting.add(src);
        for (Integer neighbor : adj.get(src)){
           if (!dfs(adj, neighbor, sorted, visited, visiting)){
            return false;
           } 
       }
       visiting.remove(src);
       visited.add(src);
       sorted.add(src);
       return true;
    }
}
