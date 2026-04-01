class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];
            adj.get(src).add(dst);
        }

        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (!dfs(adj, i, visiting, visited, sorted)){
                return new ArrayList<>();
            }
        }
        Collections.reverse(sorted);
        return sorted;
    }

// DFS with cycle protection.
    public boolean dfs(Map<Integer, List<Integer>> adj, int src, Set<Integer> visiting,
        Set<Integer> visited, List<Integer> sorted ){   
        if (visited.contains(src)){
            return true;
        }
        if (visiting.contains(src)){
            return false; 
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(adj, neighbor, visiting, visited, sorted)){
                return false;
            }
        }
        visited.add(src);
        sorted.add(src);
        visiting.remove(src);
        return true; 
    }   
}
