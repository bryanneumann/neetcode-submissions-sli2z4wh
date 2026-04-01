class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges){
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(d);
        }

        for (int i = 0; i < n; i++){
            if (!dfs_no_cycle(adj, i, visited, visiting, sorted)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs_no_cycle(Map<Integer, List<Integer>> adj, int src, Set<Integer> visited, Set<Integer> visiting,
        List<Integer> sorted){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            // cycle found
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs_no_cycle(adj, neighbor, visited, visiting, sorted)){
                return false;
            }
        }
        visiting.remove(src);
        sorted.add(src);
        visited.add(src);
        
        return true;
    }
}
