class Solution {
    private List<Integer> sorted = new ArrayList<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> visited = new HashSet<>();
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    public List<Integer> topologicalSort(int n, int[][] edges) {
        for (int i = 0; i < n; i++){
           adj.put(i, new ArrayList<>()); 
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < n; i++){
            if (!dfs(i)){
                return new ArrayList<>();
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
            // Cycle
            return false;
        }
        visiting.add(src);
        for (int neighbor : adj.get(src)){
            if (!dfs(neighbor)){
                return false;
            }
        }
        sorted.add(src);
        visited.add(src);
        visiting.remove(src);
        return true;
    }
}
