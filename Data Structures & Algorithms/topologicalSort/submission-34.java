class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();        
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
        for (int i = 0; i< n; i++){
           if (!dfs(adj, i, visiting, visited, sorted)){
            return new ArrayList<>(); 
           }
        }
        Collections.reverse(sorted);
        return sorted;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, int i, Set<Integer> visiting,
        Set<Integer> visited, List<Integer> sorted){
        if (visiting.contains(i)) {
            return false;
        }
        if (visited.contains(i)){
            return true;
        }
        visiting.add(i);
        for (int neighbor : adj.get(i)){
            if (!dfs(adj, neighbor, visiting,  visited, sorted)){
                return false;
            }
        } 
        visited.add(i);
        sorted.add(i);
        visiting.remove(i);
        return true;
    }
}
