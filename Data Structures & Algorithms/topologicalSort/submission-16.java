class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<Integer> sorted = new ArrayList<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

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
            if (!dfs(adj, i, visiting, visited, sorted)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int src, Set<Integer> visiting, Set<Integer> visited, List<Integer> sorted){
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false; // cycle
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, visiting, visited, sorted)){
                return false;
            }
        }
        sorted.add(src);
        visited.add(src);
        visiting.remove(src);
        return true;
    }
}
